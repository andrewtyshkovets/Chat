	
package com.gmail.tas;
import java.net.InetSocketAddress;
import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.*;

public class MyHttpServer {

	public static void main(String[] args) throws IOException {
		HttpServer server = HttpServer.create();
        server.bind(new InetSocketAddress(8865), 0);

      HttpContext context = server.createContext("/", new EchoHandler());
      context.setAuthenticator(new Auth());

        server.setExecutor(null);
        server.start();
    }

}