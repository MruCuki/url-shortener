package com.personaljavaprojects.url_shortener.exceptions;

public class OriginalUrlNotFoundException extends Exception {

    public OriginalUrlNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
