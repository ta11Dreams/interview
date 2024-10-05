package com.prep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SocketServer
 */
public class SocketServer {

  private ServerSocket server_socket;
  private Socket socket;

  public SocketServer(int port) {
    try {
      server_socket = new ServerSocket(port);
      System.out.println("Server started");

      ExecutorService service = Executors.newFixedThreadPool(5);

      Runnable handleRequest = () -> {
        try {
          BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          System.out.println("Request handled by " + Thread.currentThread().getName());

          String message = "";
          while (message != null && !"over".equals(message)) {
            message = reader.readLine();
            System.out.println(message);
          }

          socket.close();
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
        System.out.println("Connection closed");
      };

      while (true) {

        socket = server_socket.accept();
        service.submit(handleRequest);

        System.out.println("Connection Accepted");
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
