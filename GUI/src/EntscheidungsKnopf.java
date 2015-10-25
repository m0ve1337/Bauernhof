import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EntscheidungsKnopf
{
	private JFrame frame;
	private Antworten antworten;
	private static JButton entscheidungsButton;
	private JTextField eingabefeld;

	public EntscheidungsKnopf()
	{
		entscheidungsButton = new JButton("Random Aktivität vorschlagen!");
		antworten = new Antworten();
		eingabefeld = new JTextField(20);
		createGui();

	}

	private void createGui()
	// erstellt das Gui Fenster und fügt die Menüs, Buttons und Label hinzu
	{
		frame = new JFrame("Entscheidungsknopf");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = frame.getContentPane();
		createMenuBar();
		JButton button = randomAnswerButton();
		button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 27));
		contentPane.add(BorderLayout.CENTER, button);
		// Panel für Label, Eingabefeld und Save Button erstellen
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.darkGray);
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		contentPane.add(BorderLayout.NORTH, topPanel);

		// topPanel mit Komponenten bestücken (Label, Eingabefeld, SaveButton)
		JLabel labelEingabefeld = new JLabel("Aktivität: ");
		labelEingabefeld.setForeground(Color.white);
		topPanel.add(labelEingabefeld);

		eingabefeld.setToolTipText("Bitte hier eine Tat eingeben");
		topPanel.add(eingabefeld);
		SaveListener saveListener = new SaveListener();
		eingabefeld.addActionListener(saveListener);
		JButton saveButton = new JButton("save");
		saveButton.addActionListener(saveListener);
		topPanel.add(saveButton);

		frame.setSize(700, 500);
		frame.setVisible(true);
	}

	public JButton randomAnswerButton()
	{
		entscheidungsButton.addActionListener(new ActionListener()

		{

			@Override
			public void actionPerformed(ActionEvent e)
			{

				entscheidungsButton.setText(antworten.setRandomAntwort());
				System.out.println("Button-Label geändert");

			}

		});
		return entscheidungsButton;
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
		// ActionListener hinzufügen über innere Klasse
		oeffnenItem.addActionListener(new OeffnenListener());

		JMenuItem resetItem = new JMenuItem("Einträge löschen");
		dateiMenu.add(resetItem);
		resetItem.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{

				antworten.alleAntwortenLoeschen();
				setDeletedButtonText();

			}
		});

		JMenuItem beendenItem = new JMenuItem("Beenden");
		dateiMenu.add(beendenItem);
		beendenItem.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("beenden angeklickt");
				int wertInt = JOptionPane.showConfirmDialog(frame,
						"Wirklich beenden?", "Beenden?",
						JOptionPane.WARNING_MESSAGE);

				if (wertInt == JOptionPane.OK_OPTION)
				{

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

	public void setDeletedButtonText()
	{
		entscheidungsButton.setText("Einträge gelöscht!");
	}

	public static void setAddedText()
	{
		entscheidungsButton.setText("Eintrag hinzugefügt!");

	}

	public static void setDeclinedText()
	{
		entscheidungsButton.setText("Eintrag bereits vorhanden!");

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
	// innere Klasse
	{

		@Override
		public void actionPerformed(ActionEvent ueber)
		{
			System.out.println("über angeklickt");
			JOptionPane.showMessageDialog(frame, "Isch mega!", null,
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	class SaveListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (eingabefeld.getText().isEmpty())
			{
				entscheidungsButton.setText("bitte keine leeren Eingaben!");
			}

			else
			{
				antworten.addAntwort(eingabefeld.getText());
				eingabefeld.setText(null);
			}

		}
	}
}
