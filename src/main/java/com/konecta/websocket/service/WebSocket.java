package com.konecta.websocket.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Set;

import javax.websocket.ClientEndpointConfig;
import javax.websocket.ClientEndpointConfig.Configurator;

import com.konecta.websocket.service.vo.VOResponse;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

public class WebSocket extends Endpoint{
	
	private String url;
	private Session session;
	private String response;

	public WebSocket(String url, String response) {
		super();
		this.url = url;
		this.setResponse(response);
	}

	
	public void sendMsg(String msg) throws IOException {
		session.getAsyncRemote().sendText(msg);		
	}


	@Override
	public void onOpen(Session session, EndpointConfig config) {
		this.session = session;
		
		session.addMessageHandler(new MessageHandler.Whole<String>() {

			public void onMessage(String message) {
				System.out.println("Respuesta " + message);
				response = message;
			}
		});
	}
	
	public void connect() throws DeploymentException, IOException, URISyntaxException{
		WebSocketContainer container = ContainerProvider.getWebSocketContainer();
		
		ClientEndpointConfig config = ClientEndpointConfig.Builder.create()
				.configurator(new Configurator())
				.build();
		
		container.connectToServer(this, config, new URI(url));
	}


	/**
	 * @return the response
	 */
	public String getResponse() {
		return response;
	}


	/**
	 * @param response the response to set
	 */
	public void setResponse(String response) {
		this.response = response;
	}
	
	
	
}
