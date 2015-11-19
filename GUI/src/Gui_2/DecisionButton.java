package Gui_2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DecisionButton {

	private JFrame frame;
	private DecisionData decisionData;
	private JRadioButton ioSaveTextRadio;
	private JRadioButton ioSaveDateiRadio;
	private ButtonGroup bg1;
	private String ioMethod = "File";

	public DecisionButton() {
		decisionData = new DecisionData();
		createGui();
	}

	private void createGui() {

		frame = new JFrame("Entscheidungsknopf");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenuBar();

		Container contentPane = frame.getContentPane();

		JButton button = createButton();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(BorderLayout.NORTH, createInputPanel());
		contentPane.add(BorderLayout.CENTER, button);

		groupButton();

		frame.setSize(500, 300);
		frame.setVisible(true);
	}

	private JButton createButton() {
		final JButton button = new JButton("Klick mich");
		button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 42));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button.setText(getRandomDecision());
			}
		});
		return button;
	}

	private JPanel createInputPanel() {
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		inputPanel.add(new JLabel("Tat:"));
		final JTextField textField = new JTextField(20);
		textField.setToolTipText("Hier eine Tätigkeit eingeben");
		inputPanel.add(textField);
		JButton saveButton = new JButton("save");
		saveButton.setMnemonic(KeyEvent.VK_ENTER); // alt+enter um den button zu
													// waehlen
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveDecision(textField.getText());
				textField.requestFocus();
				textField.setText("");
			}
		});
		inputPanel.add(saveButton);
		return inputPanel;
	}

	private void saveDecision(String input) {
		AddOperationResult addOperationResult = decisionData.addDecision(input);
		if (addOperationResult.hasError()) {
			JOptionPane.showMessageDialog(frame, addOperationResult.getMessage());
		}
	}

	private String getRandomDecision() {
		return decisionData.getRandomDecision();
	}

	private void saveDecisions() {
		JFileChooser fileChooser = new JFileChooser();
		int choice = fileChooser.showSaveDialog(frame);
		if (choice == JFileChooser.APPROVE_OPTION) {
			try {

				decisionData.saveDecisions(fileChooser.getSelectedFile(), getIoMethod());

			} catch (IOException e) {
				JOptionPane.showMessageDialog(frame, "Fehler beim speichern: " + e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void loadDecisions() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		if (ioMethod == "Text") {
			FileNameExtensionFilter filterText = new FileNameExtensionFilter("Text File (.txt)", "txt");
			fileChooser.setFileFilter(filterText);
		} else if (ioMethod == "File") {
			FileNameExtensionFilter filterDatei = new FileNameExtensionFilter("Text File (.datei)", "datei");

			// TODO: implement suffix when file is saved
			fileChooser.setFileFilter(filterDatei);
		} else {
		}

		int choice = fileChooser.showOpenDialog(frame);
		if (choice == JFileChooser.APPROVE_OPTION) {

			try {
				decisionData.loadDecisions(fileChooser.getSelectedFile(), getIoMethod());

			} catch (IOException | ClassNotFoundException e) {
				JOptionPane.showMessageDialog(frame, "Fehler beim Laden: " + e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu dateiMenu = new JMenu("Datei");
		JMenuItem loadItem = new JMenuItem("Entscheidungen laden");
		loadItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				loadDecisions();

			}
		});

		JMenuItem saveItem = new JMenuItem("Entscheidungen speichern");
		saveItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				saveDecisions();

			}
		});

		JMenu ioMenu = new JMenu("IO-Change");

		ioSaveDateiRadio = new JRadioButton("Datei-Modus");
		ioSaveDateiRadio.setSelected(true);
		ioSaveDateiRadio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("save as File");
				setIoMethod("File");

			}
		});

		ioSaveTextRadio = new JRadioButton("Text-Modus");
		ioSaveTextRadio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				System.out.println("save as Text");
				setIoMethod("Text");
			}
		});

		dateiMenu.add(loadItem);
		dateiMenu.add(saveItem);
		ioMenu.add(ioSaveDateiRadio);
		ioMenu.add(ioSaveTextRadio);

		menuBar.add(dateiMenu);
		menuBar.add(ioMenu);
	}

	private void groupButton() {
		bg1 = new ButtonGroup();
		bg1.add(ioSaveTextRadio);
		bg1.add(ioSaveDateiRadio);
	}

	public String getIoMethod() {
		return ioMethod;
	}

	public void setIoMethod(String ioMethod) {
		this.ioMethod = ioMethod;
	}
}
