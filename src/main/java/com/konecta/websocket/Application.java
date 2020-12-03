package com.konecta.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.konecta.websocket.controller.Controller;
import com.konecta.websocket.controller.Util;
import com.konecta.websocket.service.vo.VORequest;
import com.konecta.websocket.service.vo.VOResponse;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		VORequest voRequestTemp = new VORequest();
		voRequestTemp.setCode("000");
		voRequestTemp.setServiceCode("001");
		voRequestTemp.setConnid("000");
		voRequestTemp.setIdentificacion("123456");
		voRequestTemp.setHost("0.0.0.0");
		voRequestTemp.setPort("21");
		voRequestTemp.setEndSeparator("~");
		ResponseEntity<?> handleRequest = handleRequest(voRequestTemp);

	}

	public static ResponseEntity<?> handleRequest(VORequest request) {

		Controller controller = new Controller();
		System.out.println("Running");

		String response = "";
		String message = request.getCode() + "," + request.getServiceCode() + "," + request.getConnid() + "," + request.getIdentificacion() + "," + request.getEndSeparator();

		try {
			response = controller.sendDocument3(request.getHost(), Integer.parseInt(request.getPort()), message);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Respuesta a retornar = " + response );

		//return new ResponseEntity<String>(response, HttpStatus.OK); 


		if( response == "" || response == null || !response.contains("613"))
			return new ResponseEntity<VOResponse>(new VOResponse("Servidor no responde", "", "", "", "", "", "", "", "", ""), HttpStatus.NOT_IMPLEMENTED);

		if(response.contains(",999,") || response.contains(",998,"))
			return new ResponseEntity<VOResponse>(new VOResponse("613", "999", "", "", "", "", "", "", "", ""), HttpStatus.NOT_IMPLEMENTED);

		VOResponse voResponse = prepareResponse(response, request.getServiceCode());

		return new ResponseEntity<VOResponse>(voResponse, HttpStatus.OK);
	}


	private static VOResponse prepareResponse(String response, String serviceCode) {

		//System.out.println("Response to split = " + response);

		String[] responseList = response.split(Util.SEPARATOR);
		VOResponse voResponse = null;

		switch (serviceCode) {
		case "000":
			System.out.println("Cliente");
			return voResponse = new VOResponse(responseList[0], responseList[1], responseList[2], responseList[3], responseList[4], " ", " ", " ", " ", " ");

		case "001":
			System.out.println("Paciente");
			return voResponse = new VOResponse(responseList[0], responseList[1], responseList[2], responseList[3], " ", responseList[4], responseList[5], responseList[6], responseList[7], responseList[8]);

		case "002":
			System.out.println("Pedido");
			return voResponse = new VOResponse(responseList[0], responseList[1], responseList[2], " ", " ", " ", " ", " ", " ", " ");

		default:
			return voResponse = new VOResponse(" ", " ", " ", " ", " ", " ", " ", " ", " ", " ");
		}

	}

}
