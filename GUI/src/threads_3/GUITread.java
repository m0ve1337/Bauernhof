package threads_3;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
public class GUITread {
	private JFrame			frame	= new JFrame("Test");
	private JPanel			panel	= new JPanel();
	private JProgressBar	bar		= new JProgressBar(0, 100);

	public void createAndShowGUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bar.setValue(0);
		bar.setSize(200, 200);
		panel.add(bar);
		JButton button = new JButton("Knopf");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Runnable barJob = new BarUpdater(bar);
				Thread updaterThread = new Thread(barJob);
				updaterThread.start();

			}
		});
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.NORTH, panel);
		frame.setSize(200, 100);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		GUITread gui = new GUITread();
		gui.createAndShowGUI();
	}
}