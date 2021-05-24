package main.java.view.guiElements.JLabelElems;

import javax.swing.ImageIcon;

import main.java.controller.handler.ScreenHandler;

import java.awt.event.MouseListener;
import java.awt.Image;

/**
 * The GUI element to display the images.
 * 
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */

public class ImageDisplay extends AbstractJLabel {

	public ImageDisplay(ScreenHandler screenHandler, Image image) {
		super(screenHandler);
		ImageIcon icon = new ImageIcon(image);
		this.setIcon(icon);
	}

	public ImageDisplay(ScreenHandler screenHandler, Image image, MouseListener listener) {
		super(screenHandler);
		ImageIcon icon = new ImageIcon(image);
		this.setIcon(icon);
		this.addMouseListener(listener);
	}

	public ImageDisplay(ScreenHandler screenHandler, Image image, int width, int height) {
		super(screenHandler);
		Image newimg = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(newimg);
		this.setIcon(icon);
	}

	public ImageDisplay(ScreenHandler screenHandler, Image image, int width, int height, MouseListener listener) {
		super(screenHandler);
		Image newimg = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(newimg);
		this.setIcon(icon);
		this.addMouseListener(listener);
	}
}
