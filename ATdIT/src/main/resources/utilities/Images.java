package main.resources.utilities;

import javax.swing.ImageIcon;

import java.awt.Image;

public class Images {
    private static String link2Images = InternalLinks.getLink2Images();
    private static Image background = getImage("background.jpg");
    private static Image german = getImage("german.jpg");
    private static Image english = getImage("english.jpg");
    private static Image logo = getImage("logo.jpg");

    private Images() {
        throw new IllegalStateException("Utility class");
    }

    private static Image getImage(String name) {
        ImageIcon icon = new ImageIcon(link2Images + name);
        return icon.getImage();
    }

    public static Image getBackground() {
        return background;
    }

    public static void setBackground(Image newImage) {
        background = newImage;
    }

    public static Image getGerman() {
        return german;
    }

    public static void setGerman(Image newImage) {
        german = newImage;
    }

    public static Image getEnglish() {
        return english;
    }

    public static void setEnglish(Image newImage) {
        english = newImage;
    }

    public static Image getLogo() {
        return logo;
    }

    public static void setLogo(Image newImage) {
        logo = newImage;
    }
}
