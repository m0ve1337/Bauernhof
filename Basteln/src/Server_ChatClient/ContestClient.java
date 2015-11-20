package Server_ChatClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
public class ContestClient {

  public void go() {
    BufferedReader reader = null;
    Socket socket = null;

    try {
      socket = new Socket("127.0.0.1", 9998);

      reader = new BufferedReader(
          new InputStreamReader(socket.getInputStream()));

      String question = reader.readLine();
      System.out.println("Die Frage lautet: " + question);


    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (reader != null) {
          reader.close();
        }
      } catch (IOException e1) {
        e1.printStackTrace();
      }
      try {
        if (socket != null) {
          socket.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    
    Socket socket2 = null;
    PrintWriter writer = null;
    try {
      socket2 = new Socket("127.0.0.1", 9999);

      writer = new PrintWriter(socket2.getOutputStream());
      writer.print("Hallo zusammen");

    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (writer != null) {
        writer.close();
      }
      try {
        if (socket2 != null) {
          socket2.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  
  public static void main(String[] args) {
    new ContestClient().go();
  }

}
