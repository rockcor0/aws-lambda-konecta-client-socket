/**
 * 
 */
package com.konecta.websocket.controller;

import com.konecta.websocket.service.WebSocket;
import com.konecta.websocket.service.WebSocketV2;
import com.konecta.websocket.service.vo.VOResponse;

/**
 * @author RicardoDelgado
 *
 */
public class Controller {

	/**
	 * 
	 */
	public Controller() {
		// TODO Auto-generated constructor stub
	}

//	public String sendDocument(String code, String serviceCode, String connid, String identification, String endCharacter) {
//
//		String response = "";
//
//		try {
//			WebSocket handle = new WebSocket(Util.URL, response);
//
//			handle.connect();
//
//			handle.sendMsg(code + "," + serviceCode + "," + connid + "," + identification + "," + endCharacter);
//
//			response = handle.getResponse();
//
//			while(response.equals("")) {
//				System.out.println("no hay respuesta" + handle.getResponse());
//				response = handle.getResponse();
//			}
//
//			//TODO
//			System.out.println("Sending");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
//
//		return response;
//
//	}
//
//	public String sendDocument2(String message) {
//
//		String response = "";
//
//		try {
//			WebSocket handle = new WebSocket(Util.URL, response);
//
//			handle.connect();
//
//			handle.sendMsg(message);
//
//			response = handle.getResponse();
//
//			while(response.equals("")) {
//				System.out.println("no hay respuesta" + handle.getResponse());
//				response = handle.getResponse();
//			}
//
//			//TODO
//			System.out.println("Sending");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
//
//		return response;
//
//	}
	
	public String sendDocument3(String host, int port, String message) throws InterruptedException {
		String response = "";
		
		WebSocketV2 handle = new WebSocketV2();
		
//		handle.openConnection();

		handle.sendMessage(message);
		handle.openConnection(host, port);
		response = handle.takeMessage();
		return response;
	}

}
