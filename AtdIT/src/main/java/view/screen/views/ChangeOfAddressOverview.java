package main.java.view.screen.views;

import java.awt.GridBagConstraints;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.plaf.InsetsUIResource;

import org.json.simple.JSONObject;

import main.java.controller.handler.ScreenHandler;
import main.java.view.guiElements.JPanelElems.Header;

public class ChangeOfAddressOverview extends AbstractView {	
	JSONObject answerJSON;
	
	protected ChangeOfAddressOverview(ScreenHandler screenHandler, JSONObject answersJSON) {
		super(screenHandler);
		this.answerJSON = answersJSON;
	}
	
	public void showJSON(JSONObject jsonObject) {
		Set<String> keys = jsonObject.keySet();
		for (String key:keys) {
			String value = (String) jsonObject.get(key);
			System.out.println(value);
		}
	}

	public void drawItems() {
		Header header = new Header(this.screenHandler);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new InsetsUIResource(20, 0, 20, 0);
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(header, gbc);
        
        Body body = new Body();
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(body, gbc);
	}
	
	public class Body extends JPanel {
		public Body() {
			
		}
	}
}
