package main.java.view.guiElements.JTextAreaElems;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import main.java.controller.handler.ScreenHandler;

public class FancyTextArea extends AbstractJTextArea {
    int areaHeight = 0;
    int areaWidth = 0;
    Color bgColor = colorHandler.getColor("textBackground");
    Color fgColor = colorHandler.getColor("textForeground");
    Font textFont = fontHandler.getFont("textArea");
    Insets insets = new Insets(10, 10, 10, 10);
    
    public FancyTextArea(ScreenHandler screenHandler) {
    	super(screenHandler);
        setAttributes();
    }

    public FancyTextArea(ScreenHandler screenHandler, int width, int height) {
    	super(screenHandler);
        this.areaWidth = width;
        this.areaHeight = height;
        setAttributes();
    }
    
    public FancyTextArea(ScreenHandler screenHandler, Color fgColor, Color bgColor) {
    	super(screenHandler);
        this.fgColor = fgColor;
        this.bgColor = bgColor;
        setAttributes();
    }
    
    public FancyTextArea(ScreenHandler screenHandler, Font textFont) {
    	super(screenHandler);
    	this.textFont = textFont;
        setAttributes();
    }
    
    public FancyTextArea(ScreenHandler screenHandler, Insets insets) {
    	super(screenHandler);
    	this.insets = insets;
        setAttributes();
    }
    
    public FancyTextArea(ScreenHandler screenHandler, int width, int height, Color fgColor, Color bgColor) {
    	super(screenHandler);
        this.areaWidth = width;
        this.areaHeight = height;
        this.fgColor = fgColor;
        this.bgColor = bgColor;
        setAttributes();
    }
    
    public FancyTextArea(ScreenHandler screenHandler, int width, int height, Font textFont) {
    	super(screenHandler);
        this.areaWidth = width;
        this.areaHeight = height;
        this.textFont = textFont;
        setAttributes();
    }  
    
    public FancyTextArea(ScreenHandler screenHandler, int width, int height, Insets insets) {
    	super(screenHandler);
    	this.insets = insets;
        this.areaWidth = width;
        this.areaHeight = height;
        setAttributes();
    }
    
    public FancyTextArea(ScreenHandler screenHandler, int width, int height, Color fgColor, Color bgColor, Font textFont) {
    	super(screenHandler);
        this.areaWidth = width;
        this.areaHeight = height;
        this.fgColor = fgColor;
        this.bgColor = bgColor;
        this.textFont = textFont;
        setAttributes();
    }
    
    public FancyTextArea(ScreenHandler screenHandler, int width, int height, Color fgColor, Color bgColor, Insets insets) {
    	super(screenHandler);
        this.areaWidth = width;
        this.areaHeight = height;
        this.fgColor = fgColor;
        this.bgColor = bgColor;
        setAttributes();
    }

    public FancyTextArea(ScreenHandler screenHandler, int width, int height, Color fgColor, Color bgColor, Font textFont, Insets insets) {
    	super(screenHandler);
    	this.insets = insets;
        this.areaWidth = width;
        this.areaHeight = height;
        this.fgColor = fgColor;
        this.bgColor = bgColor;
        this.textFont = textFont;
        setAttributes();
    }
    
    public FancyTextArea(ScreenHandler screenHandler, Color fgColor, Color bgColor, Font textFont) {
    	super(screenHandler);
    	this.textFont = textFont;
        this.fgColor = fgColor;
        this.bgColor = bgColor;
        setAttributes();
    }
    
    public FancyTextArea(ScreenHandler screenHandler, Color fgColor, Color bgColor, Insets insets) {
    	super(screenHandler);
    	this.insets = insets;
        this.fgColor = fgColor;
        this.bgColor = bgColor;
        setAttributes();
    }
    
    public FancyTextArea(ScreenHandler screenHandler, Color fgColor, Color bgColor, Font textFont, Insets insets) {
    	super(screenHandler);
    	this.setMargin(insets);
        this.textFont = textFont;
        this.fgColor = fgColor;
        this.bgColor = bgColor;
        setAttributes();
    }
    
    public FancyTextArea(ScreenHandler screenHandler, Font textFont, Insets insets) {
    	super(screenHandler);
    	this.setMargin(insets);
        this.textFont = textFont;
        setAttributes();
    }

    public void setAttributes() {
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setEditable(false);
        this.setFocusable(false);
    	this.setMargin(this.insets);
        setAreaBounds(this.areaWidth, this.areaHeight);
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
