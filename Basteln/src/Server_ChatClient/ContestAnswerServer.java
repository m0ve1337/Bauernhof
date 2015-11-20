package Server_ChatClient;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ContestAnswerServer {

  private int hits;
  private ServerSocket serverSocket;
  private static final int BUFFER_SIZE = 1000;

  public void startAnswerServer() {
    try {
      serverSocket = new ServerSocket(9999);
    } catch (IOException e1) {
      e1.printStackTrace();
      System.exit(0);
    }

    while(true) {
      Socket socket = null;
      BufferedReader reader = null;
      try {
        socket = serverSocket.accept();
        socket.setSoTimeout(100); // der read-Aufruf auf dem input-stream blockiet nur 0.1 Sekunde. Falls in dieser
        // Zeit nichts gelesen werden kann (weil nicht geschickt wird)
        // wird eine java.net.SocketTimeoutException geworfen.
        // (siehe auch javadoc)
      } catch (IOException e) {
        System.out.println("Autsch: " + e.getMessage());
      }
      
      try {
        hits++;
        reader = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));


//        System.out.println(hits + ": " +  reader.readLine());

        // Statt obigem Code mit reader.readLine() kann untenstehender Code einkommentiert werden.
        // Untenstehender Code verhindert, dass der Server in die Knie geht, falls nie ein Zeilenende kommt und Millionen von Zeichen an
        // den Server geschickt werden.

        char[] charBuffer = new char[BUFFER_SIZE];
        int zeichen = reader.read(charBuffer, 0, BUFFER_SIZE);
        
        if (zeichen >= BUFFER_SIZE) {
          System.out.println("He! Schick nicht soviele Zeichen! Es werden nur " + BUFFER_SIZE + " zeichen akzeptiert!");
        } else if (zeichen == -1){
          System.out.println("Du musst was schicken!");
        }
        
        System.out.println(hits + ": " + String.valueOf(charBuffer));

      } catch (IOException e) {
        System.out.println("Autsch: " + e.getMessage());
        
      // schliessen  
      } finally {
        if (reader != null) {
          try {
            reader.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        if (socket != null) {
          try {
            socket.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
  
  public static void main(String[] args) {
    new ContestAnswerServer().startAnswerServer();
  }
}