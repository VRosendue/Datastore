package com.postgres.connect;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
    final ServerSocket server = new ServerSocket(8083);
		
		System.out.println("Listening to port");
		
		while (true) {
			
			try (Socket socket = server.accept()) {
				Date today = new Date();
				String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
				socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
			/* spin
			Socket clientSocket = server.accept();
			InputStreamReader input = new InputStreamReader(clientSocket.getInputStream());
			BufferedReader read = new BufferedReader(input);
			String liner = read.readLine();
			while (!liner.isEmpty()) {
				System.out.println(liner);*/
			}
		}
		
	}
	
}