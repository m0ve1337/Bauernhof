import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GuiEntscheidungsKnopf {
	//TODO: Refactoring -> Klasse soll nur GUI-Aufgaben übernehmen!

	private JFrame			frame;
	private AktivitaetenListe	antworten;
	private JButton			entscheidungsButton;
	private JTextField		eingabefeld;
	private JLabel			counterLabel;
	private DisplayMessage	feedback;
	private JFileChooser	chooser;
	private IOSerialise		io;

	public GuiEntscheidungsKnopf() {
		this.feedback = new DisplayMessage("Random Aktivität vorschlagen!");
		entscheidungsButton = new JButton(feedback.getMessage());
		antworten = new AktivitaetenListe();
		eingabefeld = new JTextField(20);
		counterLabel = new JLabel();
		chooser = new JFileChooser();
		io = new IOSerialise();
		updateCounter();
		createGui();

	}

	private void createGui() {
		// erstellt das Gui Fenster und fügt die Menüs, Buttons und Label hinzu

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
		topPanel.add(counterLabel);
		counterLabel.setForeground(Color.WHITE);

		frame.setSize(700, 500);
		frame.setVisible(true);
	}

	private JButton randomAnswerButton() {
		entscheidungsButton.addActionListener(new ActionListener()

		{

			@Override
			public void actionPerformed(ActionEvent e) {

				entscheidungsButton.setText(antworten.getRandomAntwort());

			}

		});
		return entscheidungsButton;
	}

	private void updateCounter() {
		counterLabel.setText("Anzahl verfügbare Aktivitäten: " + antworten.getItemsInListe());
	}

	

	private void createMenuBar() {
		// Menüzeile (JMenuBar) erzeugen und in das Fenster (JFrame) einfügen
		JMenuBar bar = new JMenuBar();
		frame.setJMenuBar(bar);

		// Menü (JMenu) erzeugen und in die Menüzeile (Datei) einfügen
		JMenu dateiMenu = new JMenu("Datei");
		bar.add(dateiMenu);

		// Menüeinträge (laden und speichern) erzeugen und dem Menü (Datei)
		// hinzufügen
		JMenuItem ladenItem = new JMenuItem("Entscheidung laden");
		dateiMenu.add(ladenItem);
		ladenItem.addActionListener(new LadeItemsListener());
		JMenuItem saveItem = new JMenuItem("Entscheidung speichern");
		dateiMenu.add(saveItem);
		saveItem.addActionListener(new SaveItemsListener());

		// Eintrag (Einträge löschen) erzeugen und in die Menüzeile (Datei)
		// einfügen
		JMenuItem resetItem = new JMenuItem("Einträge löschen");
		dateiMenu.add(resetItem);
		resetItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("beenden angeklickt");
				int wertInt = JOptionPane.showConfirmDialog(frame, "Wirklich alle Einträge löschen?", "Löschen?",
						JOptionPane.WARNING_MESSAGE);

				if (wertInt == JOptionPane.OK_OPTION) {

					feedback = antworten.alleAntwortenLoeschen();
					entscheidungsButton.setText(feedback.getMessage());
					updateCounter();
				}

			}
		});

		// Eintrag (Beenden) erzeugen und in die Menüzeile (Datei) einfügen
		JMenuItem beendenItem = new JMenuItem("Beenden");
		dateiMenu.add(beendenItem);
		beendenItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int wertInt = JOptionPane.showConfirmDialog(frame, "Wirklich beenden?", "Beenden?",

				JOptionPane.WARNING_MESSAGE);
				if (wertInt == JOptionPane.OK_OPTION) {

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

	private class UeberListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ueber) {
			JOptionPane.showMessageDialog(frame, "Wenn langweilig: Button klicken!", "über..",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private class SaveListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			feedback = antworten.addAntwortToList(eingabefeld.getText());
			entscheidungsButton.setText(feedback.getMessage());
			eingabefeld.requestFocus();
			updateCounter();
			eingabefeld.setText(null);

		}

	}

	private class SaveItemsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int returnVal = chooser.showSaveDialog(frame);
			if (returnVal == JFileChooser.APPROVE_OPTION) {

				String path = chooser.getSelectedFile().toString();
				if (!path.endsWith(".ents")) {
					path += "." + antworten.getItemsInListe() + ".ents";
				}
				else {
					String path2 = path.substring(0, path.length() - 5);
					path2 += "." + antworten.getItemsInListe() + ".ents";
					path = path2;

				}

				io.setDirectory(path);
				io.serialise(antworten);
				entscheidungsButton.setText("Liste " + chooser.getSelectedFile().getName() + " gespeichert!");
				// TODO: check ob bereits vorhanden, dann nicht überschreiben
			}
			else {
				JOptionPane.showMessageDialog(frame, "Kein Speicherort angegeben!");
			}

			updateCounter();

		}
	}


	private class LadeItemsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent oeffnen) {

			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			FileNameExtensionFilter entschType = new FileNameExtensionFilter("Etscheidungen File (.ents)", "ents");
			chooser.setFileFilter(entschType);
			int returnVal = chooser.showOpenDialog(frame);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				//TODO try catch mit print Stactrace 
				io.setDirectory(chooser.getSelectedFile().getAbsolutePath());

				// io.deserialise kriegt die vom User ausgewählte Liste und returnt ein
				// neues (das deserialisierte) Objekt Eingabeliste.
				// Mit der Methode "listeLaden" wird die ArrayList "antworten"
				// in der Klasse Entscheidungen durch die eben geladene überschrieben.
				antworten.listeLaden(io.deserialise(antworten));
				entscheidungsButton.setText("Liste " + chooser.getSelectedFile().getName() + " geladen!");


			}
			else {
				JOptionPane.showMessageDialog(frame, "Keine Datei zum laden ausgewählt");
			}

			updateCounter();

		}

	}
}
