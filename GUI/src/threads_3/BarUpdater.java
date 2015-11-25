package threads_3;

import javax.swing.JProgressBar;

public class BarUpdater implements Runnable {
	JProgressBar	bar;
	private final Object	lock	= new Object();

	public BarUpdater(JProgressBar bar) {
		this.bar = bar;
	}

	@Override
	public void run() {


			doSomething(bar);



	}

	public  void doSomething(JProgressBar input) {
		synchronized (lock) {
		for (int i = 0; i <= 100; i++) {
			input.setValue(i);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		}
	}

}
