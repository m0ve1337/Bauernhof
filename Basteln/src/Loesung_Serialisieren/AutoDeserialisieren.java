package Loesung_Serialisieren;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class AutoDeserialisieren {

  public static void main(String[] args) {

    try (FileInputStream fis = new FileInputStream("/Users/kaspar/Desktop/auto.ser");
        ObjectInputStream ois = new ObjectInputStream(fis)) {
      
      Auto auto = (Auto) ois.readObject();

      System.out.println("Farbe: " + auto.getFarbe());
      System.out.println("Hubraum: " + auto.getMotor().getHubraum());
      System.out.println("Nummer: " + auto.getNummer());

    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
