package main.java.view.guiElements.JOptionPaneElems;

import javax.swing.JOptionPane;

import main.java.controller.handler.ScreenHandler;
import main.java.controller.handler.utilityHandler.ColorHandler;
/**
 * Basic Option Pane model.
 * 
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public abstract class AbstractJOptionPane extends JOptionPane {
	ColorHandler colorHandler;
	
	public AbstractJOptionPane(ScreenHandler screenHandler) {
		this.colorHandler = screenHandler.getColorHandler();
		this.setBackground(colorHandler.getColor("background"));
	}
}
