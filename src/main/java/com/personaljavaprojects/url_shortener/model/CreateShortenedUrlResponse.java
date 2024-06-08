package com.personaljavaprojects.url_shortener.model;

public record CreateShortenedUrlResponse(
        String shortenedUrl,
        String originalUrl,
        String errorMessage
) {
}
