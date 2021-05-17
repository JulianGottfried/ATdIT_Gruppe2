package main.java.view.guiElements.JTextAreaElems;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseListener;

import javax.swing.text.DefaultCaret;

import org.hibernate.boot.spi.AdditionalJaxbMappingProducer;

import main.java.controller.handler.ScreenHandler;

public class FancyTextArea extends AbstractJTextArea {
	private int areaHeight = 0;
	private int areaWidth = 0;
	private Color bgColor = colorHandler.getColor("textBackground");
	private Color fgColor = colorHandler.getColor("textForeground");
	private Font textFont = fontHandler.getFont("textArea");
	private Insets insets = new Insets(10, 10, 10, 10);

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

	public FancyTextArea(ScreenHandler screenHandler, String fgColorKey, String bgColorKey) {
		super(screenHandler);
		this.fgColor = colorHandler.getColor(fgColorKey);
		this.bgColor = colorHandler.getColor(bgColorKey);
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

	public FancyTextArea(ScreenHandler screenHandler, int width, int height, String fgColorKey, String bgColorKey) {
		super(screenHandler);
		this.areaWidth = width;
		this.areaHeight = height;
		this.fgColor = colorHandler.getColor(fgColorKey);
		this.bgColor = colorHandler.getColor(bgColorKey);
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

	public FancyTextArea(ScreenHandler screenHandler, int width, int height, String fgColorKey, String bgColorKey,
			Font textFont) {
		super(screenHandler);
		this.areaWidth = width;
		this.areaHeight = height;
		this.fgColor = colorHandler.getColor(fgColorKey);
		this.bgColor = colorHandler.getColor(bgColorKey);
		this.textFont = textFont;
		setAttributes();
	}

	public FancyTextArea(ScreenHandler screenHandler, int width, int height, String fgColorKey, String bgColorKey,
			Insets insets) {
		super(screenHandler);
		this.areaWidth = width;
		this.areaHeight = height;
		this.fgColor = colorHandler.getColor(fgColorKey);
		this.bgColor = colorHandler.getColor(bgColorKey);
		setAttributes();
	}

	public FancyTextArea(ScreenHandler screenHandler, int width, int height, String fgColorKey, String bgColorKey,
			Font textFont, Insets insets) {
		super(screenHandler);
		this.insets = insets;
		this.areaWidth = width;
		this.areaHeight = height;
		this.fgColor = colorHandler.getColor(fgColorKey);
		this.bgColor = colorHandler.getColor(bgColorKey);
		this.textFont = textFont;
		setAttributes();
	}

	public FancyTextArea(ScreenHandler screenHandler, String fgColorKey, String bgColorKey, Font textFont) {
		super(screenHandler);
		this.textFont = textFont;
		this.fgColor = colorHandler.getColor(fgColorKey);
		this.bgColor = colorHandler.getColor(bgColorKey);
		setAttributes();
	}

	public FancyTextArea(ScreenHandler screenHandler, String fgColorKey, String bgColorKey, Insets insets) {
		super(screenHandler);
		this.insets = insets;
		this.fgColor = colorHandler.getColor(fgColorKey);
		this.bgColor = colorHandler.getColor(bgColorKey);
		setAttributes();
	}

	public FancyTextArea(ScreenHandler screenHandler, String fgColorKey, String bgColorKey, Font textFont,
			Insets insets) {
		super(screenHandler);
		this.setMargin(insets);
		this.textFont = textFont;
		this.fgColor = colorHandler.getColor(fgColorKey);
		this.bgColor = colorHandler.getColor(bgColorKey);
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
		this.setAreaBounds(this.areaWidth, this.areaHeight);
		this.setColors(this.fgColor, this.bgColor);
		this.setFont(this.textFont);
		DefaultCaret caret = (DefaultCaret)this.getCaret();
		caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
	}

	public void setColors(Color fgColor, Color bgColor) {
		this.setForeground(fgColor);
		this.setBackground(bgColor);
	}

	public void setFont(Font textFont) {
		super.setFont(textFont);
	}

	public void setAreaBounds(int areWidth, int areaHeight) {
		this.setBounds(0, 0, areWidth, areaHeight);
	}
}
