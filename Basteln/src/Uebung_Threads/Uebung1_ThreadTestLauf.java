package Uebung_Threads;

public class Uebung1_ThreadTestLauf {
	public static void main(String[] args) {
		Runnable threadJob = new Uebung1_MeinRunnable();
		Thread meinThread = new Thread(threadJob);
		meinThread.start();
		
		System.out.println("zurück in main");
	}
}