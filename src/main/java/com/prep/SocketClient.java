package com.prep;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * SocketClient
 */
public class SocketClient {

  private Socket socket;
  private BufferedReader inps;
  private BufferedWriter outs;

  public SocketClient(String address, int port) {
    try {
      socket = new Socket(address, port);

      inps = new BufferedReader(new InputStreamReader(System.in));

      outs = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));

    } catch (Exception e) {
      e.printStackTrace();
    }

    String cmd = "";

    while (!cmd.equals("over")) {
      try {
        cmd = inps.readLine();

        outs.write(cmd);
        outs.flush();
      } catch (IOException e) {
        e.printStackTrace();
      }

    }

    try {
      inps.close();
      outs.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    SocketClient client = new SocketClient("127.0.0.1", 5000);
  }
}
