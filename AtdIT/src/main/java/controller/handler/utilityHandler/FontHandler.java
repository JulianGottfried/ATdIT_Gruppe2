package main.java.controller.handler.utilityHandler;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * The font handler gets the font codes from the .properties file.
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public class FontHandler extends AbstractUtilityHandler {

	public FontHandler(String fontTemplate) {
		super(fontTemplate);
	}
	/**
	 * Returns the font code from .properties file
	 * @param fontKey is the font key in the .properties file.
	 * @return Java font will be returned, if exists in .properties.
	 */
	public Font getFont(String fontKey) {
		String colorString = this.getProperty(fontKey);
		ArrayList<String> fontAttributes = new ArrayList<>(Arrays.asList(colorString.split("\\s*,\\s*")));
		String name = fontAttributes.get(0);
		int style = convert2Style(fontAttributes.get(1));
		int size = Integer.parseInt(fontAttributes.get(2));
		
		Font font = new Font(name, style, size);
		
		if (style == -1) {
			Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
			attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
			font = font.deriveFont(attributes);
		}
		return font;
	}
	
	/**
	 * 
	 * @param styleString enters a String to convert to style code
	 * @return the Style integer code to generate the font attributes
	 */
	private int convert2Style(String styleString) {
		int style;
		switch(styleString.toLowerCase()) {
			case "bold":  style = Font.BOLD;
				break;
			case "italic": style = Font.ITALIC;
				break;
			case "underline": style = -1;
				break;
			default: style = Font.PLAIN;
		}
		return style;
	}
}
