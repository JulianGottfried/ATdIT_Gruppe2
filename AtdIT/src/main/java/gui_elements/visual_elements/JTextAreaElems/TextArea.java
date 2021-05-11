package main.java.gui_elements.visual_elements.JTextAreaElems;

import main.resources.utilities.Fonts;

import java.awt.Color;
import java.awt.Font;

public class TextArea extends AbstractJTextArea {
    int areaHeight;
    int areWidth;
    int alpha;
    Color bgColor;
    Color fgColor;
    Font textFont;

    public TextArea(int width, int height, Color fgColor, Color bgColor, String colorTemplate) {
    	super(colorTemplate);
        this.areWidth = width;
        this.areaHeight = height;
        this.fgColor = fgColor;
        this.bgColor = bgColor;
        this.textFont = Fonts.getTextArea();
        setAttributes();
    }

    public TextArea(int width, int height, Color fgColor, Color bgColor, Font textFont, String colorTemplate) {
    	super(colorTemplate);
        this.areWidth = width;
        this.areaHeight = height;
        this.fgColor = fgColor;
        this.bgColor = bgColor;
        this.textFont = textFont;
        setAttributes();
    }

    public TextArea(int width, int height, String colorTemplate) {
    	super(colorTemplate);
        this.areWidth = width;
        this.areaHeight = height;
        this.fgColor = colorHandler.getColor("textForeground");
        this.bgColor = colorHandler.getColor("textBackground");
        this.textFont = Fonts.getTextArea();
        setAttributes();
    }

    public TextArea(int width, int height, Font textFont, String colorTemplate) {
    	super(colorTemplate);
        this.areWidth = width;
        this.areaHeight = height;
        this.fgColor = colorHandler.getColor("textForeground");
        this.bgColor = colorHandler.getColor("textBackground");
        this.textFont = textFont;
        setAttributes();
    }

    public void setAttributes() {
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setEditable(false);
        this.setFocusable(false);
        setAreaBounds(this.areWidth, this.areaHeight);
        setColors(this.fgColor, this.bgColor);
        setFont();
    }

    public void setColors(Color fgColor, Color bgColor) {
        this.setForeground(fgColor);
        this.setBackground(bgColor);
    }

    public void setFont() {
        this.setFont(this.textFont);
    }

    public void setAreaBounds(int areWidth, int areaHeight) {
        this.setBounds(0, 0, areWidth, areaHeight);
    }
}
