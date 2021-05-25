package main.java.controller.handler.utilityHandler;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * The color handler gets the color codes from the .properties file.
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public class ColorHandler extends AbstractUtilityHandler {

	public ColorHandler(String colorTemplate) {
		super(colorTemplate);
	}
	/**
	 * 
	 * @param colorKey is the color code that is included in the .properties file (e.g. "background")
	 * @return The Java Colorcode will be returned from the .properties file.
	 */
	public Color getColor(String colorKey) {
		String colorString = this.getProperty(colorKey);
		ArrayList<String> colors = new ArrayList<>();
		try {
			colors = new ArrayList<>(Arrays.asList(colorString.split("\\s*,\\s*")));
		} catch (NullPointerException npe) {
			return new Color(0, 0, 0);
		}
		int r = Integer.parseInt(colors.get(0));
		int g = Integer.parseInt(colors.get(1));
		int b = Integer.parseInt(colors.get(2));
		if (colors.size() > 3) {
			int alpha = Integer.parseInt(colors.get(3));
			return new Color(r, g, b, alpha);
		} else {
			return new Color(r, g, b);
		}
	}
}
