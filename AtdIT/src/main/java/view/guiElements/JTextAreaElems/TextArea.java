package main.java.view.guiElements.JTextAreaElems;

import java.awt.Color;
import java.awt.Font;

import main.java.controller.handler.ScreenHandler;

/**
*  
* @author weilichsoheisse
* @version 16.05.2021
*
*/

public class TextArea extends AbstractJTextArea {
    int areaHeight;
    int areWidth;
    int alpha;
    Color bgColor;
    Color fgColor;
    Font textFont;

    public TextArea(ScreenHandler screenHandler, int width, int height, Color fgColor, Color bgColor) {
    	super(screenHandler);
        this.areWidth = width;
        this.areaHeight = height;
        this.fgColor = fgColor;
        this.bgColor = bgColor;
        this.textFont = fontHandler.getFont("textArea");
        setAttributes();
    }

    public TextArea(ScreenHandler screenHandler, int width, int height, Color fgColor, Color bgColor, Font textFont) {
    	super(screenHandler);
        this.areWidth = width;
        this.areaHeight = height;
        this.fgColor = fgColor;
        this.bgColor = bgColor;
        this.textFont = textFont;
        setAttributes();
    }

    public TextArea(ScreenHandler screenHandler, int width, int height) {
    	super(screenHandler);
        this.areWidth = width;
        this.areaHeight = height;
        this.fgColor = colorHandler.getColor("textForeground");
        this.bgColor = colorHandler.getColor("textBackground");
        this.textFont = fontHandler.getFont("textArea");
        setAttributes();
    }

    public TextArea(ScreenHandler screenHandler, int width, int height, Font textFont) {
    	super(screenHandler);
        this.areWidth = width;
        this.areaHeight = height;
        this.fgColor = colorHandler.getColor("textForeground");
        this.bgColor = colorHandler.getColor("textBackground");
        this.textFont = fontHandler.getFont("textArea");
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
