package ch.zhaw.basteln;

import java.awt.Graphics;

import javax.swing.JPanel;

public class ZeichenPanel extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g)
	{
		// Image image = new
		// ImageIcon("C:/Users/m0ve/Desktop/cat.png").getImage();
		// g.setColor(Color.orange);
		// g.fillOval(20, 50, 200, 100);
		// g.drawImage(image, 3, 4, this);
	}


	public static void main(String[] args)
	{
		new ZeichenPanel();
	}
}
