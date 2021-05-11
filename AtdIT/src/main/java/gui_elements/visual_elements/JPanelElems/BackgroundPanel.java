package main.java.gui_elements.visual_elements.JPanelElems;

import main.resources.utilities.Images;

import java.awt.GridBagLayout;

import java.awt.Graphics;
import java.awt.Image;

public class BackgroundPanel extends AbstractJPanel {
    Image bg;

    public BackgroundPanel(Image image) {
        this.bg = image;
        this.setLayout(new GridBagLayout());
    }

    public BackgroundPanel() {
        this.bg = Images.getBackground();
        this.setLayout(new GridBagLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(this.bg, 0, 0, null);
    }
}
