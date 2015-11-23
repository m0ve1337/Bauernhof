package threads;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
public class GUITread {
	private JFrame			frame	= new JFrame("Test");
	private JPanel			panel	= new JPanel();
	private JProgressBar	bar		= new JProgressBar(0, 100);
	private JLabel			label	= new JLabel("Threads: ");
	private int				counter	= 0;
	public void createAndShowGUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bar.setValue(0);
		bar.setSize(200, 200);
		panel.add(bar);
		JButton button = new JButton("Knopf");
		button.addActionListener(new ActionListener() {
			@Override
			public synchronized void actionPerformed(ActionEvent e) {
				List<Thread> threads = new ArrayList<>();

				Thread barThread = new Thread(new BarUpdater());
				threads.add(barThread);

				for (Thread t : threads) {

					t.start();
					counter++;

				}

			}
		}

		);
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.NORTH, panel);
		frame.getContentPane().add(BorderLayout.CENTER, label);
		frame.setSize(200, 100);
		frame.setVisible(true);
	}
	public class BarUpdater implements Runnable {

		@Override
		public synchronized void run() {

			for (int i = 0; i <= 100; i++) {
				bar.setValue(i);
				//				if (i == 100) {
				//					counter--;
				//}
				
				
				try {
					Thread.sleep(50);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				label.setText("Threads: " + counter);
			}

		}
	}

}