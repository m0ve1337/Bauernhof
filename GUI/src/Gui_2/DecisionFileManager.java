package Gui_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DecisionFileManager {

	public void save(File file, List<String> decisions) throws IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			oos.writeObject(decisions);
		}
	}

	public List<String> load(File file) throws IOException, ClassNotFoundException {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			List<String> decisions = (List<String>) ois.readObject();
			return decisions;
		}
	}

	public void saveAsText(File file, List<String> decisions) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

			for (String entry : decisions) {
				writer.write(entry);
				writer.write(System.getProperty("line.separator"));

			}
		}
	}

	public List<String> loadAsText(File file) throws IOException {
		try (FileReader fileReader = new FileReader(file); BufferedReader reader = new BufferedReader(fileReader)) {
			String zeile = reader.readLine();
			List<String> decisions = new ArrayList<>();

			while (zeile != null) {
				decisions.add(zeile);
				zeile = reader.readLine();

			}
			return decisions;

		}
	}
}
