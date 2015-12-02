package loesung;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class GUITreadLoesung2 {
  private JFrame frame = new JFrame("Test");
  private JPanel panel = new JPanel();
  private JProgressBar bar = new JProgressBar(0, 100);
  private JLabel label = new JLabel();
  private int numberOfThreads = 0;
  
  private final Object lock1 = new Object();
  private final Object lock2 = new Object();
  
  public void createAndShowGUI() {
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    bar.setValue(0);
    bar.setSize(200, 200);
    panel.add(bar);
    label.setText(String.valueOf(numberOfThreads));
    
    JButton button = new JButton("Knopf");
    button.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        Thread t = new Thread(new Runnable() {
          @Override
          public void run() {
            synchronized (lock1) {
              label.setText(String.valueOf(++numberOfThreads));
            }
            
            synchronized (lock2) {
              doSomething();
            }
            
            synchronized (lock1) {
              label.setText(String.valueOf(--numberOfThreads));
            }
          }
        });
        t.start();
      
      }
    });
   
    frame.getContentPane().add(BorderLayout.SOUTH, button);
    frame.getContentPane().add(BorderLayout.CENTER, label);
    frame.getContentPane().add(BorderLayout.NORTH, panel);
    
    frame.setSize(200, 100);
    frame.setVisible(true);
  }
  
  private void doSomething() {

    for (int i = 0; i <= 100; i++) {
      bar.setValue(i);
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
