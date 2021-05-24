package main.java.view.guiElements.JPanelElems;

import javax.swing.JPanel;

import main.java.controller.handler.ScreenHandler;
import main.java.controller.handler.utilityHandler.*;
/**
 * Basic Panel model.
 * 
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public abstract class AbstractJPanel extends JPanel {
	ColorHandler colorHandler;
	FontHandler fontHandler;
	ImageHandler imageHandler;
	ScreenHandler screenHandler;

	public AbstractJPanel(ScreenHandler screenHandler) {
		this.screenHandler = screenHandler;
		this.colorHandler = screenHandler.getColorHandler();
		this.fontHandler = screenHandler.getFontHandler();
		this.imageHandler = screenHandler.getImageHandler();
		this.setBackground(colorHandler.getColor("background"));
	}
}
