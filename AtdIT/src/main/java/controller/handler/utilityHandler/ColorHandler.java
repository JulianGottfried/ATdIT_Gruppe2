package main.java.controller.handler.utilityHandler;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * This class gets and returns the colour from resources.
 * @author weilichsoheisse
 * @version 16.05.2021
 *
 */
public class ColorHandler extends AbstractUtilityHandler {

	public ColorHandler(String colorTemplate) {
		super(colorTemplate);
	}
	
	public Color getColor(String colorKey) {
		String colorString = this.getProperty(colorKey);
		ArrayList<String> colors = new ArrayList<>(Arrays.asList(colorString.split("\\s*,\\s*")));
		int r = Integer.parseInt(colors.get(0));
		int g = Integer.parseInt(colors.get(1));
		int b = Integer.parseInt(colors.get(2));
		if (colors.size() > 3) {
			int alpha = Integer.parseInt(colors.get(0));
			return new Color(r, g, b, alpha);
		} else {
			return new Color(r, g, b);
		}
	}
}
