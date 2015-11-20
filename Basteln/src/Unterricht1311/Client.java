package Unterricht1311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {

		Socket chatSocket = null;
		try {
			chatSocket = new Socket("192.168.43.219", 9998);
		} catch (UnknownHostException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		

		InputStreamReader strom = null;
		try {
			strom = new InputStreamReader(chatSocket.getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		BufferedReader reader = new BufferedReader(strom);
		try {
			String message = reader.readLine();
			System.out.println(message);
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		}

}
	}

