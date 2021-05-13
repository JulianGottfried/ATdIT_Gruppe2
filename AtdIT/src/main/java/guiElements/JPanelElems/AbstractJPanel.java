package main.java.guiElements.JPanelElems;

import javax.swing.JPanel;

import main.java.handler.ScreenHandler;
import main.java.handler.utilityHandler.ColorHandler;
import main.java.handler.utilityHandler.FontHandler;
import main.java.handler.utilityHandler.ImageHandler;

public abstract class AbstractJPanel extends JPanel {
	ColorHandler colorHandler;
	FontHandler fontHandler;
	ImageHandler imageHandler;

	public AbstractJPanel(ScreenHandler screenHandler) {
		this.colorHandler = screenHandler.getColorHandler();
		this.fontHandler = screenHandler.getFontHandler();
		this.imageHandler = screenHandler.getImageHandler();
		this.setBackground(colorHandler.getColor("background"));
	}
}
