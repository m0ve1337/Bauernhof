package threads;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
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
	private List<Thread>	threads	= new ArrayList<>();

	public void createAndShowGUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bar.setValue(0);
		bar.setSize(200, 200);
		panel.add(bar);
		JButton button = new JButton("Knopf");
		button.addActionListener(new ActionListener() {
			@Override
			public synchronized void actionPerformed(ActionEvent e) {
				Thread updater = new Thread(new BarUpdater());

				threads.add(updater);
				System.out.println("thread 2 ArrayList added");
				counter++;

				System.out.println(counter);
				updater.start();

			}
		}

		);
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.NORTH, panel);
		frame.getContentPane().add(BorderLayout.CENTER, label);
		frame.setSize(200, 100);
		frame.setVisible(true);
	}
	private class BarUpdater implements Runnable {

		@Override
		public synchronized void run() {

			Iterator<Thread> it = threads.iterator();

			while (it.hasNext()) {
				System.out.println("asd");
				System.err.println("asd2");

			}

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
	}

}