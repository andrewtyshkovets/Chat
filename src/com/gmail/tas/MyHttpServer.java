	
package com.gmail.tas;
import com.sun.net.httpserver.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;


public class MyHttpServer {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create();
        InetAddress InetAdress;
        InetAdress = InetAddress.getByName("127.0.0.1");
        server.bind(new InetSocketAddress(InetAdress,1234), 50);

        HttpContext context = server.createContext("/", new EchoHandler());
        context.setAuthenticator(new Auth());

        server.setExecutor(null);
        server.start();
        System.out.println("Server is running");
    }

    static class EchoHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            StringBuilder builder = new StringBuilder();

            getMethod(exchange);
          
            builder.append("<h1>URI: ").append(exchange.getRequestURI()).append("</h1>");

            Headers headers = exchange.getRequestHeaders();
            for (String header : headers.keySet()) {
                builder.append("<p>").append(header).append("=")
                        .append(headers.getFirst(header)).append("</p>");
            }

            byte[] bytes = builder.toString().getBytes();
            exchange.sendResponseHeaders(200, bytes.length);

            OutputStream os = exchange.getResponseBody();
            System.out.println(builder);
            os.write(bytes);
            os.close();
        }
    }
    
    
    static void getMethod(HttpExchange ex) {
    	String line = ex.getRequestMethod();
    	switch(line) {
    	case "GET":
    		System.out.println("This is GET request");
    		break;
    	case "POST":
    		System.out.println("This is POST request");
    		break;
    		
    	}	
    }
    

    static class Auth extends Authenticator {
        @Override
        public Result authenticate(HttpExchange httpExchange) {
            if ("/forbidden".equals(httpExchange.getRequestURI().toString()))
                return new Failure(403);
            else
                return new Success(new HttpPrincipal("c0nst", "realm"));
        }
    }
}