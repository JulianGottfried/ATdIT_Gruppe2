package main.java.gui_elements.visual_elements;

import javax.swing.JTextArea;

import main.resources.utilities.Colors;
import main.resources.utilities.Fonts;

import java.awt.Color;
import java.awt.Font;

public class TextArea extends JTextArea {
    int areaHeight;
    int areWidth;
    int alpha;
    Color bgColor;
    Color fgColor;
    Font textFont;

    public TextArea(int width, int height, Color fgColor, Color bgColor, int alpha) {
        super(0, 0);

        this.areWidth = width;
        this.areaHeight = height;
        this.fgColor = fgColor;
        this.alpha = alpha;
        this.bgColor = opacityColor(bgColor, this.alpha);
        this.textFont = Fonts.getTextArea();

        setAttributes();
    }

    public TextArea(int width, int height, Color fgColor, Color bgColor, int alpha, Font textFont) {
        super(0, 0);

        this.areWidth = width;
        this.areaHeight = height;
        this.fgColor = fgColor;
        this.alpha = alpha;
        this.bgColor = opacityColor(bgColor, this.alpha);
        this.textFont = textFont;

        setAttributes();
    }

    public TextArea(int width, int height) {
        super(0, 0);

        this.areWidth = width;
        this.areaHeight = height;
        this.fgColor = Colors.getTextForeground();
        this.alpha = Colors.getTextBackgroundAlpha();
        this.bgColor = opacityColor(Colors.getTextBackground(), this.alpha);
        this.textFont = Fonts.getTextArea();

        setAttributes();
    }

    public TextArea(int width, int height, Font textFont) {
        super(0, 0);

        this.areWidth = width;
        this.areaHeight = height;
        this.fgColor = Colors.getTextForeground();
        this.alpha = Colors.getTextBackgroundAlpha();
        this.bgColor = opacityColor(Colors.getTextBackground(), this.alpha);
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

    public Color opacityColor(Color color, int alpha) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();

        return new Color(r, g, b, alpha);
    }
}
