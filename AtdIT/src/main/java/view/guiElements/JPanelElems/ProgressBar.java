package main.java.view.guiElements.JPanelElems;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

import main.java.controller.handler.ScreenHandler;

public class ProgressBar extends AbstractJPanel {
	ArrayList<ProgressRect> progressRects;
	Dimension rectDimensions;

	public ProgressBar(ScreenHandler screenHandler, String bgColorKey, Dimension dimensions, int elemCount) {
		super(screenHandler);
		progressRects = new ArrayList<ProgressRect>();
		this.setLayout(new GridBagLayout());
		this.setMinimumSize(dimensions);
		this.setBackground(colorHandler.getColor(bgColorKey));
		this.setBorder(BorderFactory.createLineBorder(colorHandler.getColor("frameBorder"), 5, true));
		this.setPreferredSize(new Dimension(600, 800));
		setRectDimensions(dimensions, elemCount);
				
		for (int i=0; i<elemCount; i++) {
			ProgressRect pr = new ProgressRect();
			this.progressRects.add(i, pr);
			pr.setMinimumSize(rectDimensions);
			
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = elemCount - i - 1;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.fill = GridBagConstraints.BOTH;
			gbc.insets = new Insets(0, 5, 0, 5);
			this.add(pr, gbc);
		}
	}
	
	public void setRectDimensions(Dimension progBarDim, int elemCount) {
		int width = (int) progBarDim.getWidth();
		int height = (int) progBarDim.getHeight()/elemCount;
		this.rectDimensions = new Dimension(width, height);
	}
	
	public class ProgressRect extends JLabel {
		public ProgressRect() {
			this.setBackground(colorHandler.getColor("progressBarBlock"));
			this.setMinimumSize(rectDimensions);
		}
	}
}
