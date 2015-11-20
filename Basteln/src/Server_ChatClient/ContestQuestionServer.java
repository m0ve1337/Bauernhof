package Server_ChatClient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ContestQuestionServer {

  private int hits;
  private ServerSocket serverSocket;

  public void startQuestionServer() {
    try {
      serverSocket = new ServerSocket(9998);
    } catch (IOException e1) {
      e1.printStackTrace();
      System.exit(0);
    }

    while(true) {
      PrintWriter writer = null;
      Socket socket = null;
      try {
        socket = serverSocket.accept();
      } catch (IOException e) {
        System.out.println("Autsch: " + e.getMessage());
      }
      hits ++;
      try {
        writer = new PrintWriter(
            socket.getOutputStream());

        writer.println("Was macht die Methode \"accept()\" "
            + "der Klasse \"ServerSocket\"?");
        System.out.println("Zugriffe: " + hits);
      } catch (IOException e) {
        e.printStackTrace();
        
      // schliessen der sockets und writer
      } finally {
        if (writer != null) {
          writer.close();
        }
        if (socket != null) {
          try {
            socket.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      } // end finally
    }
  }
  
  public static void main(String[] args) {
    new ContestQuestionServer().startQuestionServer();
  }
}
