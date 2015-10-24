package ch.zhaw.basteln;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Uebung3
{
	public static void main(String[] args)
	{
		Uebung3 gui = new Uebung3();
		gui.los();
	}

	private void los()
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		frame.add(BorderLayout.EAST, panel);
		JButton button = new JButton("hau drauf");
		JButton button2 = new JButton("super gemacht!");
		panel.add(button2);
		panel.add(button);

		frame.setSize(250, 200);
		frame.setVisible(true);
	}

}
