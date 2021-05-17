package main.java.view.guiElements.JPanelElems;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import main.java.controller.handler.ScreenHandler;
import main.java.view.guiElements.JTextAreaElems.FancyTextArea;

public class ProgressBarLabel extends AbstractJPanel {
	private GridBagConstraints gbc;
	private ProgressBar progBar;
	private FancyTextArea title;
	private FancyTextArea description;
	private FancyTextArea lowerText;
	private FancyTextArea upperText;
	
	public ProgressBarLabel(ScreenHandler screenHandler, ProgressBar progBar, String bgColorKey, Dimension dimensions) {
		super(screenHandler);
		this.progBar = progBar;
		this.setBackground(colorHandler.getColor(bgColorKey));
		this.setLayout(new GridBagLayout());
		this.setProgBar(this.progBar);
	}
	
	public void setProgBar(ProgressBar progBar) {
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = GridBagConstraints.REMAINDER;
		this.add(progBar, gbc);
	}
	
	public void setTitle(FancyTextArea title) {
		this.title = title;
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(this.title, gbc);
	}
	
	public void setUpperText(FancyTextArea upperText) {
		this.upperText = upperText;
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		this.add(this.upperText, gbc);
	}
	
	public void setDescription(FancyTextArea description) {
		this.description = description;
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridheight = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(this.description, gbc);
	}
	
	public void setLowerText(FancyTextArea lowerText) {
		this.lowerText = lowerText;
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridheight = GridBagConstraints.REMAINDER;
//		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.anchor = GridBagConstraints.LAST_LINE_END;
		this.add(this.lowerText, gbc);
	}
}
