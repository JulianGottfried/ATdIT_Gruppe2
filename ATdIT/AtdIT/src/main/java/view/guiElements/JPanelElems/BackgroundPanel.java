package main.java.view.guiElements.JPanelElems;

import java.awt.GridBagLayout;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import main.java.controller.handler.ScreenHandler;
/**
 * The Background UI element creation.
 * 
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public class BackgroundPanel extends AbstractJPanel {
    Image bg;
    JPanel panel;

    public BackgroundPanel(ScreenHandler screenHandler, Image image) {
    	super(screenHandler);
    	this.panel = new JPanel();
        this.bg = image;
        this.setLayout(new GridBagLayout());
    }

    public BackgroundPanel(ScreenHandler screenHandler) {
    	super(screenHandler);
    	this.panel = new JPanel();
        this.bg = imageHandler.getImage("background");
        this.setLayout(new GridBagLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        panel.paintComponents(g);

        g.drawImage(this.bg, 0, 0, null);
    }
}
