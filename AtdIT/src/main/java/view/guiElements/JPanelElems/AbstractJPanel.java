package main.java.view.guiElements.JPanelElems;

import javax.swing.JPanel;

import main.java.controller.handler.ScreenHandler;
import main.java.controller.handler.utilityHandler.*;

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