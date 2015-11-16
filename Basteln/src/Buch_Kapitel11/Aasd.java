package Buch_Kapitel11;

import java.util.Map;
import java.util.TreeMap;

public class Aasd {

	Map<String, String>	telBuch;

	public Aasd() {
		telBuch = new TreeMap<>();
	}

	public void addEntry(String name, String nummer) {
		
		telBuch.put(name, nummer);
	}

	public void printTelBuch() {

		System.out.println(telBuch.keySet());
		System.out.println(telBuch.values());

	}

	public static void main(String[] args) {
		Aasd telbuch = new Aasd();

		telbuch.addEntry("Hans", "123");
		telbuch.addEntry("Fritz", "23112");
		telbuch.addEntry("asdasd", "1231231231");

		telbuch.printTelBuch();

	}
}