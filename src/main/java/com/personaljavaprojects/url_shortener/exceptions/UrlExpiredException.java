package com.personaljavaprojects.url_shortener.exceptions;

public class UrlExpiredException extends Exception {

    public UrlExpiredException(String message) {
        super(message);
    }
}
