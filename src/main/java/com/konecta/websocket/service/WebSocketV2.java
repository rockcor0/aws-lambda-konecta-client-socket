package com.konecta.websocket.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.PriorityBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("socketClient")
public class WebSocketV2 {
	
//	@Value("brain.connection.port")
//    int tcpPort;
//	
//    @Value("brain.connection.ip")
//    String ipConnection;
    
    private Socket clientSocket;

	private DataOutputStream outToTCP;
    private BufferedReader inFromTCP;

    private PriorityBlockingQueue<String> incomingMessages = new PriorityBlockingQueue<>();
    private PriorityBlockingQueue<String> outcomingMessages = new PriorityBlockingQueue<>();

    private final Logger log = LoggerFactory.getLogger(this.getClass());

	private Thread sendDataToTCP = new Thread(){
        public void run(){
            String sentence = "";
            log.info("Starting Backend -> TCP communication thread");
            System.out.println("Iniciando mensaje");
            while(true){
                try {
                    sentence = incomingMessages.take();
                    outToTCP.writeBytes(sentence + '\n');
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    };

    private Thread getDataFromTCP = new Thread(){
        public void run(){
            log.info("Starting TCP -> Backend communication thread");
            while(true){
                String response = "";
                try {
                    response = inFromTCP.readLine();
                    if (response == null)
                        break;
                    outcomingMessages.put("Mensaje " + response);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public void openConnection(String host, int port){
        try {
//            this.clientSocket = new Socket("172.20.73.20", 9613);
        	this.clientSocket = new Socket(host, port);
            outToTCP = new DataOutputStream(clientSocket.getOutputStream());
            inFromTCP = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            getDataFromTCP.start();
            sendDataToTCP.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Send messages to Socket.
    public void sendMessage(String message) throws InterruptedException {
        incomingMessages.put(message);
    }
    //Take Message from Socket
    public String takeMessage() throws InterruptedException {
    	String mensaje = outcomingMessages.take();
    	System.out.println("Respuesta " + mensaje);
        return mensaje;
    }
}
