package com.pagisoft;

public class Utils {

    public static String removePolishCharacters(String originalString) {

        String processedString = originalString
                .replace("ą", "a")
                .replace("ć", "c")
                .replace("ę", "e")
                .replace("ł", "l")
                .replace("ń", "n")
                .replace("ó", "o")
                .replace("ś", "s")
                .replace("ż", "z")
                .replace("ź", "z");

        return processedString;
    }

    public static String replaceSpacesWithDashes(String originalString) {
        String processedString = originalString
                .replace(" ", "-")
                .replaceAll("--+", "-")
                .replaceAll("^-+", "")
                .replaceAll("-+$", "")
                .replaceAll("\\s+","");

        return processedString;
    }
}
