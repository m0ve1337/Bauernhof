package threads;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

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
	private Stack<Thread>	threads	= new Stack<>();

	public void createAndShowGUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bar.setValue(0);
		bar.setSize(200, 200);
		panel.add(bar);
		JButton button = new JButton("Knopf");
		button.addActionListener(new ActionListener() {
			@Override
			public synchronized void actionPerformed(ActionEvent e) {

				//				BarUpdater job = new BarUpdater();
				//				Thread updater = new Thread(job);
				//
				//				threads.push(updater);
				//				System.out.println("thread 2 Stack added");

				System.out.println(counter);

				new Thread() {
					@Override
					public void run() {
						doSomething();
					}

					private synchronized void doSomething() {
						for (int i = 0; i <= 100; i++) {
							bar.setValue(i);

							try {
								Thread.sleep(50);

							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							label.setText("Threads: " + counter);
						}

					}
				}.start();

			}
		}

		);
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.NORTH, panel);
		frame.getContentPane().add(BorderLayout.CENTER, label);
		frame.setSize(200, 100);
		frame.setVisible(true);
	}
}

//	private class BarUpdater implements Runnable {
//
//		@Override
//		public synchronized void run() {
//
//			System.out.println("threads size: " + threads.size());
//
//			doSomething();
//
//		}
//		private void doSomething() {
//			for (int i = 0; i <= 100; i++) {
//				bar.setValue(i);
//
//				try {
//					Thread.sleep(50);
//
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				label.setText("Threads: " + counter);
//			}
//		}
//
//	}

