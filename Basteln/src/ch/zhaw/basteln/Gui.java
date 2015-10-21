package ch.zhaw.basteln;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Gui
{
	JFrame frame = new JFrame();
	JButton button = new JButton("button klicken");

	public Gui()
	{


		frame.add(button);

		button.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				button.setText("wurde geklickt!");
			}
		});

		frame.setSize(400, 500);
		frame.add(new ZeichenPanel());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public static void main(String[] args)
	{
		new Gui();
	}
	

}
