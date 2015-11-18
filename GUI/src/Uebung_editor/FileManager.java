package Uebung_editor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;

public class FileManager {

	public String getText(File file) throws IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			StringBuilder out = new StringBuilder();
			String line = br.readLine();
			while (line  != null){
				 out.append(line);
				 out.append("\n");
				 line=br.readLine();
			}

			return out.toString();

		}
	}
	
	public void setText(File input) throws IOException{
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(input))){
			//bw.write(input);
		}
		
		
	}

		
	

}
