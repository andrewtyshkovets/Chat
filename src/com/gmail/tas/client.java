package com.gmail.tas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class client {

	private static int port;
	private static String address;

	public static void main(String[] args) {

		port = 1234;
		address = "localhost";

		try {
			InetAddress ipAddress = InetAddress.getByName(address);
			Socket socket = new Socket(ipAddress, port);
			System.out.println("Socket with ip: " + address + " and port " + port + " is created");

			InputStream sin = socket.getInputStream();
			OutputStream sout = socket.getOutputStream();

			BufferedReader in = new BufferedReader(new InputStreamReader(sin));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(sout));

			BufferedReader keybord = new BufferedReader(new InputStreamReader(System.in));
			String line = null;

			System.out.println("Type something");
			System.out.println();

			while (true) {
				line = keybord.readLine();
				System.out.println("Sending line to the server");
				out.write(line);
				out.flush();
				line = in.readLine();
				System.out.println("Server's answer :" + line);
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
