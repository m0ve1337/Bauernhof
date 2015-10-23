package ch.zhaw.basteln;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Gui
{
	JFrame frame = new JFrame();
	JButton button = new JButton("change Color");
	ZeichenPanel panel = new ZeichenPanel();

	public Gui()
	{


		frame.add(button);

		button.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				panel.repaint();
			}
		});

		frame.setSize(500, 500);
		frame.add(BorderLayout.CENTER, panel);
		frame.add(BorderLayout.SOUTH, button);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public static void main(String[] args)
	{
		new Gui();
	}
	

}
