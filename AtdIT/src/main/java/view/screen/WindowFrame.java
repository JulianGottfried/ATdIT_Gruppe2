package main.java.view.screen;

import javax.swing.JFrame;

/**
* This class is only used to create the frame. 
* @author weilichsoheisse
* @version 16.05.2021
*
*/

public class WindowFrame extends JFrame {
    public WindowFrame() {
        this.setTitle("Rathaus 2077");
        this.setSize(600, 400);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}