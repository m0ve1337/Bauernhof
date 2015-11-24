package test1;

public class Start_Threads {

	public static void main(String[] args) {

		Thread guiTh = new Thread(new GUITread());
		guiTh.start();

	}

}
