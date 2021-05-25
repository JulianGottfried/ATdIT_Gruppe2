package main.java.view.guiElements.JPanelElems;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import main.java.controller.handler.ScreenHandler;
import main.java.view.guiElements.JLabelElems.ImageDisplay;

public class KeyValueDisplay extends AbstractJPanel {

	public KeyValueDisplay(ScreenHandler screenHandler) {
		super(screenHandler);
		this.setLayout(new GridBagLayout());
		this.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
	}
	
	public void showPairsString(HashMap<String, String> pairMap) {
		Set<String> keys = pairMap.keySet();
		
		GridBagConstraints gbc;
		int i = 0;
		for (String key:keys) {
			String value = pairMap.get(key);
			
			JLabel keyLabel = new JLabel(key);
			keyLabel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
			gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = i;
			this.add(keyLabel, gbc);
			
			JLabel valueLabel = new JLabel(value);
			valueLabel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
			gbc = new GridBagConstraints();
			gbc.gridx = 1;
			gbc.gridy = i;
			this.add(valueLabel, gbc);
			
			i++;
		}
	}

	public void showPairsBoolean(HashMap<String, Boolean> pairMap) {
		Set<String> keys = pairMap.keySet();
		
		GridBagConstraints gbc;
		int i = 0;
		for (String key:keys) {
			Boolean value = pairMap.get(key);
			ImageDisplay image;
			if (value) {
				image = new ImageDisplay(screenHandler, imageHandler.getImage("checkmark"), -1, 50);
			} else {
				image = new ImageDisplay(screenHandler, imageHandler.getImage("x"), -1, 50);
			}
			
			JLabel keyLabel = new JLabel(key);
			keyLabel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
			gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = i;
			gbc.insets = new Insets(40, 40, 40, 40);
			this.add(keyLabel, gbc);

			image.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
			gbc = new GridBagConstraints();
//			gbc.weightx = 1.0;
//			gbc.weighty = 1.0;
//			gbc.fill = GridBagConstraints.BOTH;
			gbc.insets = new Insets(40, 40, 40, 40);
			gbc.gridx = 1;
			gbc.gridy = i;
			this.add(image, gbc);
			
			i++;
		}
	}
}
