package main.java.screen;

import javax.swing.JFrame;

public class Start extends JFrame {
    public Start() {
        this.setTitle("Rathaus 2077");
        this.setSize(600, 400);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}