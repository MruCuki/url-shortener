package com.personaljavaprojects.url_shortener.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "tbl_url_mapping")
public class UrlMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "original_url", unique = true, nullable = false)
    private String originalURL;

    @Column(name = "short_url", unique = true, nullable = false)
    private String shortenedURL;

    @Column(name = "link_expiry", nullable = false)
    private LocalDate linkExpiry;
}
