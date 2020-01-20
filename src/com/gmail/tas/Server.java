package com.gmail.tas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Server {

	private static int port;

	public static void main(String[] arg) {

		port = 1234;

		try (ServerSocket ss = new ServerSocket(port)) {

			System.out.println("Waiting for a client");
			while (true) {
				Socket socket = ss.accept();
				System.out.println("Client is connected");

				try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						PrintWriter out = new PrintWriter(socket.getOutputStream())) {


					while (!in.ready()) {
					}
					System.out.println("stream has been read");
					String line;
					while (in.ready()) {
						line = in.readLine();
						System.out.println(line);
					}
					out.println("HTTP/1.1 200 OK");
					out.println("Content-Type: text/html; charset=utf-8");
					out.println();
					out.println(
							"<p><img src=https://images-na.ssl-images-amazon.com/images/I/8166xCVDGnL._SY355_.jpg><h1>Hello!</h1></p>");
					out.flush();
				}
					
			}
		} catch (Exception x) {
			x.printStackTrace();
		}

	}
}
