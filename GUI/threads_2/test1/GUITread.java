package test1;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
public class GUITread implements Runnable {
	private JFrame			frame	= new JFrame("Test");
	private JPanel			panel	= new JPanel();
	private JProgressBar	bar		= new JProgressBar(0, 100);
	private JLabel			label	= new JLabel();
	private int				initialThreads;
	int						queuedThreads	= 0;

	public synchronized void createAndShowGUI() {
		initialThreads = Thread.activeCount();
		System.out.println("initial(1):" + initialThreads);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bar.setValue(0);
		bar.setSize(200, 200);
		panel.add(bar);
		JButton button = new JButton("Knopf");

		button.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {
				setLabelText();

				new Thread(() -> {
					doSomething(initialThreads);
				}).start();



			}
		});
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.NORTH, panel);
		frame.getContentPane().add(BorderLayout.CENTER, label);
		frame.setSize(200, 100);
		frame.setVisible(true);
	}

	private synchronized void doSomething(int initialThreads) {

		queuedThreads = Thread.activeCount();
		System.out.println(queuedThreads);


		setLabelText();

		for (int i = 0; i <= 100; i++) {
			bar.setValue(i);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			queuedThreads = Thread.activeCount();

			setLabelText();
		}
	}

	private void setLabelText() {
		label.setText("Threads waiting: " + (queuedThreads - initialThreads));
	}

	@Override
	public void run() {
		GUITread guiThread = new GUITread();
		guiThread.createAndShowGUI();
	}
}