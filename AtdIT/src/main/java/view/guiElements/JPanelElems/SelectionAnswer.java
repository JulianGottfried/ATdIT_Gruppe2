package main.java.view.guiElements.JPanelElems;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import main.java.controller.handler.ScreenHandler;
import main.java.view.guiElements.AnswerInterface;

public class SelectionAnswer extends AbstractJPanel implements AnswerInterface {
	
	public SelectionAnswer(ScreenHandler screenHandler, String[] options, boolean selectSingle) {
		super(screenHandler);
		this.setLayout(new GridBagLayout());
		
		ButtonGroup bg = new ButtonGroup();
		for (int i=0; i<options.length; i++) {
			JRadioButton jb = new JRadioButton(options[i]);
			
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = i%2;
			gbc.gridy = i/2;
			gbc.insets = new Insets(5, 5, 5, 5);
			gbc.anchor = GridBagConstraints.LINE_START;
			this.add(jb, gbc);
			if (selectSingle) {
				bg.add(jb);
			}
		}
	}
	
}
