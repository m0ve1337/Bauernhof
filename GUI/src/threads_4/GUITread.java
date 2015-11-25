package threads_4;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
public class GUITread {
	private JFrame			frame	= new JFrame("Test");
	private JPanel			panel	= new JPanel();
	private JProgressBar	bar		= new JProgressBar(0, 100);

	static ExecutorService newFixedThreadPool(int nThreads) {
		return null;
	}

	public void createAndShowGUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bar.setValue(0);
		bar.setSize(200, 200);
		panel.add(bar);
		JButton button = new JButton("Knopf");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doSomething();
			}
		});
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.NORTH, panel);
		frame.setSize(200, 100);
		frame.setVisible(true);
	}
	private void doSomething() {
		for (int i = 0; i <= 100; i++) {
			bar.setValue(i);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}