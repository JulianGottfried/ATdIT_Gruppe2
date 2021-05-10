package main.resources.utilities;

import java.awt.Font;

public class Fonts {

    private static Font h1 = new Font(Font.DIALOG, Font.BOLD, 32);
    private static Font textArea = new Font(Font.DIALOG, Font.BOLD, 18);
    private static Font button = new Font(Font.DIALOG, Font.BOLD, 14);

    private Fonts() {
        throw new IllegalStateException("Utility class");
    }

    public static Font getH1() {
        return h1;
    }

    public static void setH1(Font newFont) {
        h1 = newFont;
    }

    public static Font getTextArea() {
        return textArea;
    }

    public static void setTextArea(Font newFont) {
        textArea = newFont;
    }

    public static Font getButton() {
        return button;
    }

    public static void setButton(Font newFont) {
        button = newFont;
    }
}
