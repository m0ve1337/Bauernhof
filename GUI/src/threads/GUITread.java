package threads;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
public class GUITread {
	private JFrame			frame		= new JFrame("Test");
	private JPanel			panel		= new JPanel();
	private JProgressBar	bar			= new JProgressBar(0, 100);
	private JLabel			label		= new JLabel("Threads waiting: ");
	private int				counter		= 0;
	private BarUpdater		updaterJob	= new BarUpdater();

	public void createAndShowGUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bar.setValue(0);
		bar.setSize(200, 200);
		panel.add(bar);
		JButton button = new JButton("Knopf");

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				counter++;
				setLabelText();

				Thread updaterThread = new Thread(updaterJob);
				updaterThread.start();

			}
		}

		);
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.NORTH, panel);
		frame.getContentPane().add(BorderLayout.CENTER, label);
		frame.setSize(200, 100);
		frame.setVisible(true);
	}

	private void setLabelText() {
		label.setText("Threads waiting: " + counter);

	}

	private class BarUpdater implements Runnable {

		@Override
		public void run() {

			doSomething();
		}

		private synchronized void doSomething() {
			// eigenes Lock erstellen!

			for (int i = 0; i <= 100; i++) {
				bar.setValue(i);

				try {
					Thread.sleep(50);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			counter--;
			setLabelText();

		}

	}
}
