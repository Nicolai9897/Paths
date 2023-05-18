package no.ntnu.idatg2001.paths.ui;


import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
  public static void main(String[] args) {
    Frame frame = new Frame("Game");
    frame.setSize(400, 400);

    Panel panel = new Panel();
    frame.add(panel);

    Button startButton = new Button("Start Game");
    startButton.addActionListener(e -> {
      // Start game code here
    });
    panel.add(startButton);

    Button exitButton = new Button("Exit Game");
    exitButton.addActionListener(e -> System.exit(0));
    panel.add(exitButton);

    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });

    frame.setVisible(true);
  }
}