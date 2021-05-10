package main.java.gui_elements.visual_elements;

import javax.swing.ImageIcon;

import java.awt.event.MouseListener;
import java.awt.Image;

import javax.swing.JLabel;

public class ImageDisplay extends JLabel {

    public ImageDisplay(Image image) {
        ImageIcon icon = new ImageIcon(image);
        this.setIcon(icon);
    }

    public ImageDisplay(Image image, MouseListener listener) {
        ImageIcon icon = new ImageIcon(image);
        this.setIcon(icon);
        this.addMouseListener(listener);
    }

    public ImageDisplay(Image image, int width, int height) {
        Image newimg = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(newimg);
        this.setIcon(icon);
    }

    public ImageDisplay(Image image, int width, int height, MouseListener listener) {
        Image newimg = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(newimg);
        this.setIcon(icon);
        this.addMouseListener(listener);
    }
}
