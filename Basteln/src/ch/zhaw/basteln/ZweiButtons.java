package ch.zhaw.basteln;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ZweiButtons
{
	JFrame frame;
	JLabel label;

	public static void main(String[] args)
	{
		ZweiButtons gui = new ZweiButtons();
		gui.los();
	}

	private void los()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton labelButton = new JButton("Aendere Label");
		labelButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				label.setText("Autsch");
			}
		});

		JButton colorButton = new JButton("Aendere Kreis");
		colorButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				frame.repaint();
			}
		});

		label = new JLabel("Ich bin ein Label");
		ZeichenPanel panel = new ZeichenPanel();

		frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.getContentPane().add(BorderLayout.EAST, labelButton);
		frame.getContentPane().add(BorderLayout.WEST, label);

		frame.setSize(420, 300);
		frame.setVisible(true);
	}

}
