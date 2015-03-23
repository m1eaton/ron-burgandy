package com.emc.cyclone.platform.server.verticals.handlers;

import org.vertx.java.core.Handler;
import org.vertx.java.core.http.HttpServerRequest;


public class BasicServerHandler implements Handler<HttpServerRequest> {

	private int counter = 0;
	
	@Override
	public void handle(HttpServerRequest request) 
	{
		request.response().setChunked(true);
		try{
			counter++;
			System.out.println("----------------------");
			System.out.println("Request number "+counter+" has arrived!");
			System.out.println("Request Method "+request.method());
			System.out.println("Request Path "+request.path());
			
			System.out.println("----------------------");
			request.response().write("Hello You have reached Vert.x POC http Vertical");
			request.response().write("Request number "+counter+" has arrived!");					
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
		}
		finally
		{
			request.response().end();
		}
	}

		
}
