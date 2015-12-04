package uhr;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;

import Beispielcode.executor.Runnable1;

public class Gui {
	JFrame	frame			= new JFrame();
	JButton	buttonGui		= new JButton("change Display to GUI");
	JButton	buttonConsole	= new JButton("change Display to Console");
	boolean	runningConsole	= false;
	ExecutorService executor = Executors.newCachedThreadPool();


	public Gui() {

		frame.add(buttonConsole);
		frame.add(buttonGui);

		buttonConsole.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {



				if (!runningConsole) {
					Runnable r1 = new ConsoleOut("Console");


					executor.execute(r1);
					runningConsole = true;

				}
				else {

					executor.shutdown();
					runningConsole = false;

				}

			}
		});

		frame.setSize(200, 200);
		frame.add(BorderLayout.SOUTH, buttonConsole);
		frame.add(BorderLayout.NORTH, buttonGui);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new Gui();
	}

}
