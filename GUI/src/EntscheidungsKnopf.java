import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class EntscheidungsKnopf
{
	private JFrame frame;
	private List<String> antworten;
	private Random randomGenerator;

	public EntscheidungsKnopf()
	{
		createGui();
		antworten = new ArrayList<String>();
		setDefaultAntworten();

	}

	private void createGui()
	//ToDo: Button als eigene Methode anlegen (Rückgabetyp: Button implementiert direkt
	// den ActionListener. Achtung: Button muss FINAL sein!
	// Button wird so implementiert : Jbutton button = createButton();
	{
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
				button.setText(getRandomAntwort());
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
				beendenJoption();
				
			}

			private void beendenJoption() {
				int wertInt = JOptionPane.showConfirmDialog(frame,"Wirklich beenden?");
				
				if(wertInt == JOptionPane.OK_OPTION){
				
					System.exit(0);
				}
			
				}
				
			

		});

		// Menü (Hilfe) erzeugen und in die Menüzeile (JMenuBar) einfügen
		JMenu hilfeMenu = new JMenu("Hilfe");
		bar.add(hilfeMenu);
		JMenuItem hilfeItem = new JMenuItem("Über");
		hilfeMenu.add(hilfeItem);
		hilfeItem.addActionListener(new UeberListener());

	}

	private void setDefaultAntworten()
	{
		antworten.add("Surfern lernen");
		antworten.add("Einen Lamborghini fahren");
		antworten.add("Bungee jumping");
		antworten.add("Wakeboarden");
		antworten.add("Snowboarden");
		antworten.add("Windsurfen lernen");
		antworten.add("Polarlichter beobachten");
		antworten.add(" Eine andere Sprache lernen");
		antworten.add("Einen Striptease hinlegen");
		antworten.add(" 2 Tage durchfeiern");
		antworten.add("Ein Tattoo stechen lassen");
		antworten.add("Die 10 besten Filme aller Zeiten sehen");
		antworten.add("2 Tage Fasten");
		antworten.add("Einen Baum mit einer Axt fällen ");
		antworten.add("Eine Nacht im Gefängnis verbringen");

	}

	private String getRandomAntwort()
	{
		randomGenerator = new Random();
		int index = randomGenerator.nextInt(antworten.size());
		return antworten.get(index);
	}

	class OeffnenListener implements ActionListener
	// innere Klasse
	{

		@Override
		public void actionPerformed(ActionEvent oeffnen)
		{
			System.out.println("öffnen angeklickt ");

		}

	}

	class UeberListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent ueber)
		{
			System.out.println("über angeklickt");
		}
	}
}
