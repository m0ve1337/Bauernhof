package ch.zhaw.basteln;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class EinfacheAnimation
{
	int x = 70;
	int y = 70;

	public static void main(String[] args)
	{
		EinfacheAnimation gui = new EinfacheAnimation();
		gui.los();
	}
		
		public void los(){
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		MeinZeichenPanel zeichenPanel = new MeinZeichenPanel();
			
			frame.getContentPane().add(zeichenPanel);
			frame.setSize(300, 300);
			frame.setVisible(true);

		

		for (int i = 0; i < 130; i++)
		{
			x++;
			y++;
			zeichenPanel.repaint();
			try
			{
				Thread.sleep(50);
			} catch (Exception e)
			{
			}
			
		}

	}

	class MeinZeichenPanel extends JPanel
	{
		/**
			 * 
			 */
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g)
		{
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.setColor(Color.GREEN);
			g.fillOval(x, y, 40, 40);
		}
	}
}

