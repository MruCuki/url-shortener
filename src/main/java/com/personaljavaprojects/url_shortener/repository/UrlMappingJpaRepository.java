package com.personaljavaprojects.url_shortener.repository;

import com.personaljavaprojects.url_shortener.entity.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlMappingJpaRepository extends JpaRepository<UrlMapping, Long> {

    UrlMapping findByOriginalURL(String originalURL);

    UrlMapping findByShortenedURL(String shortenedURL);
}
