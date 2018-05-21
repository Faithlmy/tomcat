package com.learnhttp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class webSocket {
	
	
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		Socket sk = new Socket("10.129.4.97",8080);
		OutputStream os = sk.getOutputStream();
		boolean outflush = true;
		BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		System.out.println("GET /index.jsp HTTP/1.1");
		System.out.println("host:localhost:8080");
		System.out.println("Connection:close");
		System.out.println();
		
		boolean loop = true;
		StringBuffer sb = new StringBuffer(8089);
		while(loop) {
			if(in.ready()) {
				int i = 1;
				while(i != -1) {
					i = in.read();
					sb.append((char) i);
				}
				loop = false;
			}
			Thread.currentThread().sleep(50);
		}
		
	}
	
	

}
