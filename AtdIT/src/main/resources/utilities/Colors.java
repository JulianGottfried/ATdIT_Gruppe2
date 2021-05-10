package main.resources.utilities;

import java.awt.Color;

public class Colors {
    private static Color background = new Color(255, 255, 255);

    private static Color menuButton1 = new Color(105, 140, 255);
    private static Color menuButton2 = new Color(64, 214, 84);
    private static Color menuButton3 = new Color(255, 170, 0);
    private static Color menuButton4 = new Color(255, 10, 20);
    private static Color menuButtonText = new Color(255, 255, 255);

    private static Color textForeground = new Color(255, 255, 255);
    private static Color textBackground = new Color(128, 128, 128);
    private static int textBackgroundAlpha = 180;

    private static Color h1 = new Color(255, 255, 255);
    private static Color h2 = new Color(255, 255, 255);
    private static Color h3 = new Color(255, 255, 255);

    private Colors() {
        throw new IllegalStateException("Utility class");
    }

    public static Color getMenuButton1() {
        return menuButton1;
    }

    public static void setMenuButton1(Color newColor) {
        menuButton1 = newColor;
    }

    public static Color getMenuButton2() {
        return menuButton2;
    }

    public static void setMenuButton2(Color newColor) {
        menuButton2 = newColor;
    }

    public static Color getMenuButton3() {
        return menuButton3;
    }

    public static void setMenuButton3(Color newColor) {
        menuButton3 = newColor;
    }

    public static Color getMenuButton4() {
        return menuButton4;
    }

    public static void setMenuButton4(Color newColor) {
        menuButton4 = newColor;
    }

    public static Color getMenuButtonText() {
        return menuButtonText;
    }

    public static void getMenuButtonText(Color newColor) {
        menuButtonText = newColor;
    }

    public static Color getBackground() {
        return background;
    }

    public static void setBackground(Color newColor) {
        background = newColor;
    }

    public static Color getTextForeground() {
        return textForeground;
    }

    public static void getTextForeground(Color newColor) {
        textForeground = newColor;
    }

    public static Color getTextBackground() {
        return textBackground;
    }

    public static void setTextBackground(Color newColor) {
        textBackground = newColor;
    }

    public static int getTextBackgroundAlpha() {
        return textBackgroundAlpha;
    }

    public static void setTextBackgroundAlpha(int newAlpha) {
        textBackgroundAlpha = newAlpha;
    }

    public static Color getH1() {
        return h1;
    }

    public static void setH1(Color newColor) {
        h1 = newColor;
    }

    public static Color getH2() {
        return h2;
    }

    public static void setH2(Color newColor) {
        h2 = newColor;
    }

    public static Color getH3() {
        return h3;
    }

    public static void setH3(Color newColor) {
        h3 = newColor;
    }
}