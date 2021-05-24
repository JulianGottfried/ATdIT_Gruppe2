package main.java.view.guiElements.JPanelElems;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

import main.java.controller.handler.ScreenHandler;
/**
 * The progress bar on the left side of the COA process.
 * 
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public class ProgressBar extends AbstractJPanel {
	private ArrayList<ProgressBox> progressBoxes;
	private String boxColorKey;

	public ProgressBar(ScreenHandler screenHandler, Dimension dimensions, String bgColorKey, String boxColor) {
		super(screenHandler);
		this.boxColorKey = boxColor;
		this.setLayout(new GridBagLayout());
		this.setMinimumSize(dimensions);
		this.setBackground(colorHandler.getColor(bgColorKey));
		this.setBorder(BorderFactory.createLineBorder(colorHandler.getColor("frameBorder"), 5, true));
		this.setPreferredSize(dimensions);
	}
	
	public void setBoxes(int boxesCount) {
		progressBoxes = new ArrayList<ProgressBox>();
		
		for (int i=0; i<boxesCount; i++) {
			ProgressBox pr = new ProgressBox();
			progressBoxes.add(pr);
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = boxesCount - i - 1;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.fill = GridBagConstraints.BOTH;
			gbc.insets = new Insets(1, 5, 1, 5);
			this.add(pr, gbc);
		}
	}
	
	public class ProgressBox extends JLabel {
		public ProgressBox() {
			this.setBackground(colorHandler.getColor(boxColorKey));
			this.setOpaque(false);
		}
	}
	
	public void emptyBar() {
		for (int i=0; i<progressBoxes.size(); i++) {
			updateBox(i, false);
		}
	}
	
	public void updateBox(int index, boolean show) {
		ProgressBox progressBox = progressBoxes.get(index);
		progressBox.setOpaque(show);
		this.revalidate();
		this.repaint();
	}
}
