package com.emc.cyclone.platform.server.verticals;



import org.vertx.java.core.http.HttpServer;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.platform.Verticle;

import com.emc.cyclone.platform.server.verticals.handlers.BasicServerHandler;

public class HttpServerVertical  extends Verticle{

	
	
	
	public void start()
	{
		System.out.println("** HttpServerVertical Starting **");
		createHttpServer();
		System.out.println("** HttpServerVertical Starting **");
	}

	
	private  HttpServer createHttpServer()
	{
		System.out.println("** Starting Http HttpServerVertical**");
		HttpServer server = vertx.createHttpServer();		
		BasicServerHandler handler = new BasicServerHandler();
		server.requestHandler(handler);
		server.listen(8080,"localhost");
		System.out.println("** Http HttpServerVertical listening on 8080 **");
			
		return server;
	}
	

	
	public static void Main(String[] args)
	{
		HttpServerVertical server = new HttpServerVertical();
		server.start();
	}
	
}
