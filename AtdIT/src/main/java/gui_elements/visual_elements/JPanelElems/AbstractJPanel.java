package main.java.gui_elements.visual_elements.JPanelElems;

import javax.swing.JPanel;

import main.java.handler.ColorHandler;

public class AbstractJPanel extends JPanel {
	ColorHandler colorHandler;

	public AbstractJPanel(String colorTemplate) {
		this.colorHandler = new ColorHandler(colorTemplate);
		this.setBackground(colorHandler.getColor("background"));
	}
	
	public AbstractJPanel() {
	}
}
