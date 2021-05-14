package main.java.view.handler.utilityHandler;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FontHandler extends AbstractUtilityHandler {

	public FontHandler(String fontTemplate) {
		super(fontTemplate);
	}
	
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
