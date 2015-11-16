package Loesung_Serialisieren;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class AutoSerialisieren {

  public static void main(String[] args) {

    Auto a1 = new Auto("Rot", new Motor(1200));
    a1.setNummer("ZH 123");

    try (FileOutputStream fos = new FileOutputStream("/Users/kaspar/Desktop/auto.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {

      oos.writeObject(a1);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
