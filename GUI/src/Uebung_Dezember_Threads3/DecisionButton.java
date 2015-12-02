package Uebung_Dezember_Threads3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;
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
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

public class DecisionButton {

	private JFrame			frame;
	private DecisionData	decisionData;

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

			SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
				@Override
				protected Void doInBackground() throws Exception {
					try {

						
						System.out.println("saving");
						frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
						decisionData.saveDecisions(fileChooser.getSelectedFile());
						Thread.sleep(4000);

						System.out.println("saving done");

					} catch (IOException e) {
						JOptionPane.showMessageDialog(frame, "Fehler beim speichern: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					} finally {
						frame.setCursor(Cursor.getDefaultCursor());
					}

					return null;
				}
			};

			worker.execute();

		}
	}

	private void loadDecisions() {
		JFileChooser fileChooser = new JFileChooser();
		int choice = fileChooser.showOpenDialog(frame);
		if (choice == JFileChooser.APPROVE_OPTION) {

			SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
				@Override
				protected Void doInBackground() throws Exception {
					try {

						System.out.println("loading");
						decisionData.loadDecisions(fileChooser.getSelectedFile());
						frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

						Thread.sleep(4000);

						System.out.println("loading done ");

					} catch (IOException | ClassNotFoundException e) {
						JOptionPane.showMessageDialog(frame, "Fehler beim Laden: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					} finally {
						frame.setCursor(Cursor.getDefaultCursor());
					}

					return null;
				}
			};
			worker.execute();

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

		dateiMenu.add(loadItem);
		dateiMenu.add(saveItem);
		menuBar.add(dateiMenu);

		// io-strategy
		JMenu strategyMenu = new JMenu("IO-Strategie");
		final JRadioButtonMenuItem objectStreamItem = new JRadioButtonMenuItem("Object");
		objectStreamItem.setSelected(true);
		objectStreamItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				decisionData.setIOStrategy(new ObjectStreamStrategy());
			}
		});
		strategyMenu.add(objectStreamItem);

		final JRadioButtonMenuItem fileItem = new JRadioButtonMenuItem("File");
		fileItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				decisionData.setIOStrategy(new FileIOStrategy());
			}
		});
		strategyMenu.add(fileItem);

		ButtonGroup saveStrategyGroup = new ButtonGroup();
		saveStrategyGroup.add(objectStreamItem);
		saveStrategyGroup.add(fileItem);

		menuBar.add(strategyMenu);
	}
}
