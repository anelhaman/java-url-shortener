package com.example.urlshortener.repository;

import com.example.urlshortener.model.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface URLRepository extends JpaRepository<URL, Long> {
    Optional<URL> findByShortUrl(String shortUrl);
}
