package Uebung_editor;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Gui {

	JFrame	frame;
	JTextArea	textFeld;
	FileManager	filemanager	= new FileManager();


	public Gui() {
		frame = new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = frame.getContentPane();

		createMenuBar();

		JLabel kopfzeile = new JLabel("DateiVariable");
		//TODO Variable einfügen
		contentPane.add(kopfzeile, BorderLayout.NORTH);

		JButton saveButton = new JButton("save");
		contentPane.add(saveButton, BorderLayout.SOUTH);



		JTextArea textFeld = new JTextArea();
		textFeld.setText("Text laden");

		contentPane.add(textFeld, BorderLayout.CENTER);

		frame.setSize(700, 500);
		frame.setVisible(true);
	}

	private void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu dateiMenu = new JMenu("Datei");
		menuBar.add(dateiMenu);

		JMenuItem ladenItem = new JMenuItem("laden");
		dateiMenu.add(ladenItem);
		ladenItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("laden...");
				readText();

			}
		});

	}

	private void readText() {
	    JFileChooser fileChooser = new JFileChooser();
	    int choice = fileChooser.showOpenDialog(frame);
	    if (choice == JFileChooser.APPROVE_OPTION) {
	      try {
				String test = filemanager.getText(fileChooser.getSelectedFile());
				textFeld.setText(test);


	      } catch (IOException e) {
				JOptionPane.showMessageDialog(frame, "Fehler beim laden: " + e.getMessage(),
	            "Error", JOptionPane.ERROR_MESSAGE);
	      }
	    }
	  }

}
