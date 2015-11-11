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

public class GuiEntscheidungsKnopf {
	private JFrame frame;
	private Entscheidungen antworten;
	private JButton entscheidungsButton;
	private JTextField eingabefeld;
	private JLabel counterLabel;
	private DisplayMessage message;
	IOSerialise io ;

	public GuiEntscheidungsKnopf() {
		this.message = new DisplayMessage("Random Aktivität vorschlagen!");
		entscheidungsButton = new JButton(message.getMessage());
		antworten = new Entscheidungen();
		eingabefeld = new JTextField(20);
		counterLabel = new JLabel();
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
				System.out.println("Button-Label geändert");

			}

		});
		return entscheidungsButton;
	}

	private void updateCounter() {
		counterLabel.setText("Anzahl verfügbare Aktivitäten: "
				+ antworten.getItemsInListe());
	}

	private void createMenuBar() {
		// Menüzeile (JMenuBar) erzeugen und in das Fenster (JFrame) einfügen
		JMenuBar bar = new JMenuBar();
		frame.setJMenuBar(bar);

		// Menü (JMenu) erzeugen und in die Menüzeile (Datei) einfügen
		JMenu dateiMenu = new JMenu("Datei");
		bar.add(dateiMenu);

		// Menüeinträge (JMenuItem) erzeugen und dem Menü (JMenu) "Datei"
		// hinzufügen
		JMenuItem oeffnenItem = new JMenuItem("Entscheidung laden");

		dateiMenu.add(oeffnenItem); // Eintrag dem Dateimenü hinzufügen
		oeffnenItem.addActionListener(new LadeItemsListener());
		JMenuItem saveItem = new JMenuItem("Entscheidung speichern");
		dateiMenu.add(saveItem);
		saveItem.addActionListener(new SaveItemsListener());

		JMenuItem resetItem = new JMenuItem("Einträge löschen");
		dateiMenu.add(resetItem);
		resetItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("beenden angeklickt");
				int wertInt = JOptionPane.showConfirmDialog(frame,
						"Wirklich alle Einträge löschen?", "Löschen?",
						JOptionPane.WARNING_MESSAGE);

				if (wertInt == JOptionPane.OK_OPTION) {

					message = antworten.alleAntwortenLoeschen();
					entscheidungsButton.setText(message.getMessage());
					updateCounter();
				}

			}
		});

		JMenuItem beendenItem = new JMenuItem("Beenden");
		dateiMenu.add(beendenItem);

		beendenItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("beenden angeklickt");
				int wertInt = JOptionPane.showConfirmDialog(frame,
						"Wirklich beenden?", "Beenden?",
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
		// innere Klasse

		@Override
		public void actionPerformed(ActionEvent ueber) {
			System.out.println("über angeklickt");
			JOptionPane.showMessageDialog(frame,
					"Wenn langweilig: Button klicken!", "über..",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private class SaveListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			message = antworten.addAntwortToList(eingabefeld.getText());
			entscheidungsButton.setText(message.getMessage());
			eingabefeld.requestFocus();
			updateCounter();
			eingabefeld.setText(null);

		}

	}

	private class SaveItemsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int returnVal = chooser.showSaveDialog(frame);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				io.setSpeicherort(chooser.getSelectedFile().getAbsolutePath());
				System.out.println(io.getSpeicherort());
				io.serialise(antworten);

			}
			else {
				JOptionPane.showMessageDialog(frame,
						"Kein Speicherort angegeben!");
			}

			updateCounter();

		}
	}

	private class LadeItemsListener implements ActionListener {
		// innere Klasse

		@Override
		public void actionPerformed(ActionEvent oeffnen) {
			System.out.println("öffnen angeklickt ");

			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int returnVal = chooser.showOpenDialog(frame);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				io.setSpeicherort(chooser.getSelectedFile().getAbsolutePath());
				System.out.println(io.getSpeicherort());
				antworten.listeLaden(io.deserialise(antworten));

			} else {
				JOptionPane.showMessageDialog(frame,
						"Keine Datei zum laden ausgewählt");
			}

			updateCounter();

		}

	}
}
