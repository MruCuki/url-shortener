package com.personaljavaprojects.url_shortener.service;

import com.personaljavaprojects.url_shortener.exceptions.OriginalUrlNotFoundException;
import com.personaljavaprojects.url_shortener.exceptions.UrlExpiredException;
import com.personaljavaprojects.url_shortener.exceptions.UrlHashingException;

public interface ShortenedUrlService {

    String createShortenedUrl(String originalUrl) throws UrlHashingException;

    String getOriginalUrl(String shortenedUrl) throws OriginalUrlNotFoundException, UrlExpiredException;
}
