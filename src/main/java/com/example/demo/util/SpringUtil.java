package com.example.demo.util;

import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

public class SpringUtil {
    private static final Pattern NONLATIN = Pattern.compile("[\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

    public static String toSlup(String input) {
        String nowhitespace = WHITESPACE.matcher(input).replaceAll("_");
        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }
}