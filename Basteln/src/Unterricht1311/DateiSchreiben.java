package Unterricht1311;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DateiSchreiben {
	
	public static void main(String[] args) {
		
		File file = new File("/Users/ZHAW/Desktop/datei.txt");
		// File Objekt ist virtuell, wie Adresse (nach dieser Zeile wird noch nichts geschrieben!)
		
		File dir = new File("/Users/ZHAW/Desktop/test");

				dir.mkdir();
				
				try (FileWriter fw = new FileWriter(file)){
					fw.write("bla");
					
					
					
				}catch (IOException e) {
					e.printStackTrace();
				}
	}

}
