package Uebung_Threads;

public class Uebung1_MeinRunnable implements Runnable {
	@Override
	public void run() {
		los();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void los() {
		tuNochMehr();
	}

	private void tuNochMehr() {
		System.out.println("Oben auf den Stack");
	}
}