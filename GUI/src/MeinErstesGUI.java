import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MeinErstesGUI
{
	private JFrame frame;

	public MeinErstesGUI()
	{
		createFrame();



	}

	private void createFrame()
	{



		Entscheidungsknopf randomButton = new Entscheidungsknopf();

		frame = new JFrame("Entscheidungsknopf");
		createMenuBar();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = frame.getContentPane();

		JButton button = new JButton("Ich bin ein riesen Button: drück mich");
		button.addActionListener(new ActionListener()

		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				button.setText(randomButton.randomAntwort());
				System.out.println("Button-Label geändert");

			}


		});
		contentPane.add(button);
		// frame.pack();
		frame.setSize(500, 500);
		frame.setVisible(true);
	}

	private void createMenuBar()
	{
		// Menüzeile (JMenuBar) erzeugen und in das Fenster (JFrame) einfügen
		JMenuBar bar = new JMenuBar();
		frame.setJMenuBar(bar);

		// Menü (JMenu) erzeugen und in die Menüzeile (Datei) einfügen
		JMenu dateiMenu = new JMenu("Datei");
		bar.add(dateiMenu);

		// Menüeinträge (JMenuItem) erzeugen und dem Menü (JMenu) "Datei"
		// hinzufügen
		JMenuItem oeffnenItem = new JMenuItem("Öffnen");

		dateiMenu.add(oeffnenItem); // Eintrag dem Dateimenü hinzufügen
		oeffnenItem.addActionListener(new OeffnenListener());
		// ActionListener hinzufügen über innere Klasse

		JMenuItem beendenItem = new JMenuItem("Beenden");
		dateiMenu.add(beendenItem);
		beendenItem.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("beenden angeklickt");
				System.exit(0);
			}

		});

		// Menü (Hilfe) erzeugen und in die Menüzeile (JMenuBar) einfügen
		JMenu hilfeMenu = new JMenu("Hilfe");
		bar.add(hilfeMenu);
		JMenuItem hilfeItem = new JMenuItem("Über");
		hilfeMenu.add(hilfeItem);
		hilfeItem.addActionListener(new UeberListener());

	}

	class OeffnenListener implements ActionListener
	// innere Klasse
	{

		@Override
		public void actionPerformed(ActionEvent oeffnen)
		{
			System.out.println("öffnen angeklickt");
		}

	}

	class UeberListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent ueber)
		{
			System.out.println("ueber angeklickt");
		}
	}
}
