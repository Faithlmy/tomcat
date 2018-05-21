package com.learnhttp;

import java.io.*;
import java.net.*;


public class HttpServer {

	public static final String WEB_ROOT = System.getProperty("usr.dir" + File.separator  + "webroot");
	private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
	private boolean shutdown = false;
	
	public void await() {
		ServerSocket ss = null;
		int port = 8080;
		try {
			ss = new ServerSocket(port, 1, InetAddress.getByName("10.148.84.110"));
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
		
		while(!shutdown) {
			Socket socket = null;
			InputStream input = null;
			OutputStream output = null;
			
			try {
				socket = ss.accept();
				input = socket.getInputStream();
				output = socket.getOutputStream();
				Request re = new Request(input);
//				Response rs = new Response();
//				rs.setRequest(rs);
			}catch(Exception e) {
				
			}
		}
	}
}
