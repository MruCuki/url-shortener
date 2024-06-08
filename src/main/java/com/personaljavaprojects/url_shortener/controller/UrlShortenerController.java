package com.personaljavaprojects.url_shortener.controller;

import com.personaljavaprojects.url_shortener.exceptions.OriginalUrlNotFoundException;
import com.personaljavaprojects.url_shortener.exceptions.UrlHashingException;
import com.personaljavaprojects.url_shortener.model.CreateShortenedUrlRequest;
import com.personaljavaprojects.url_shortener.model.CreateShortenedUrlResponse;
import com.personaljavaprojects.url_shortener.service.ShortenedUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UrlShortenerController {

    private ShortenedUrlService shortenedUrlService;
    @Autowired
    public UrlShortenerController(ShortenedUrlService shortenedUrlService) {
        this.shortenedUrlService = shortenedUrlService;
    }

    @PostMapping("/shorten-url")
    public ResponseEntity<CreateShortenedUrlResponse> createShortenedURL(@RequestBody CreateShortenedUrlRequest request) {

        String shortenedUrl;
        try {
            shortenedUrl = this.shortenedUrlService.createShortenedUrl(request.url());
        } catch (UrlHashingException e) {
            return ResponseEntity.internalServerError()
                    .body(new CreateShortenedUrlResponse(null, request.url(), e.getMessage()));
        }
        return ResponseEntity.ok(
                new CreateShortenedUrlResponse(shortenedUrl, request.url(), null));
    }

    @GetMapping("/shorten-url")
    public ModelAndView redirectToTheOriginalURL(
            @RequestParam(name="shortened-url") String shortenedURL
    ) {

        String originalURL;
        try {
            originalURL = this.shortenedUrlService.getOriginalUrl(shortenedURL);
        } catch (OriginalUrlNotFoundException e) {
            return new ModelAndView("error");
        }
        return new ModelAndView(new StringBuilder().append("redirect:").append(originalURL).toString());
    }
}
