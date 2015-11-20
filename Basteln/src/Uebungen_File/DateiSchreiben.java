package Uebungen_File;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DateiSchreiben {

  public static void main(String[] args) {
    
    File file = new File("/Users/kaspar/Desktop/datei.txt");
    
    try (FileWriter fw = new FileWriter(file)) {
      fw.write("bla");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}