package com.personaljavaprojects.url_shortener.utils;

import com.personaljavaprojects.url_shortener.exceptions.UrlHashingException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class UrlShortenerHelper {

    public static String generateHash(String originalUrl) throws UrlHashingException {

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(originalUrl.getBytes(StandardCharsets.UTF_8));
            return Base64.getUrlEncoder().encodeToString(hashBytes).substring(0, 6);
        } catch (NoSuchAlgorithmException e) {
            throw new UrlHashingException("An error occurred while hashing the original URL");
        }
    }
}
