package main.resources.utilities;

public class InternalLinks {
    private static String link2Images = "AtdIT/src/main/resources/images/";
    private static String link2bundles = "main/resources/i18n/";

    private InternalLinks() {
        throw new IllegalStateException("Utility class");
    }

    public static String getLink2Images() {
        return link2Images;
    }

    public static void setLink2Images(String newLink) {
        link2Images = newLink;
    }

    public static String getLink2bundles() {
        return link2bundles;
    }

    public static void getLink2bundles(String newLink) {
        link2bundles = newLink;
    }
}
