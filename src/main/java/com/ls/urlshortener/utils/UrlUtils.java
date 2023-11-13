package com.ls.urlshortener.utils;

public class UrlUtils {

    public static String generateShortUrl(long decimalId) {
        return baseEncode(decimalId, "abcdefghijkmnopqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ0123456789");
    }

    private static String baseEncode(long decimalId, String characters) {
        int base = characters.length();
        StringBuilder encoded = new StringBuilder();
        if (decimalId == 0) {
            return String.valueOf(characters.charAt(0));
        }
        while (decimalId > 0) {
            int remainder = (int) (decimalId % base);
            encoded.insert(0, characters.charAt(remainder));
            decimalId /= base;
        }

        return encoded.toString();
    }
}
