package com.example.urlshortener.service;

import com.example.urlshortener.model.URL;
import com.example.urlshortener.repository.URLRepository;
import com.example.urlshortener.util.URLShortener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class URLService {
    private final URLRepository urlRepository;

    public URLService(URLRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String shorten(String longUrl) {
        String shortUrl = URLShortener.generateShortURL();
        URL url = new URL();
        url.setShortUrl(shortUrl);
        url.setLongUrl(longUrl);
        urlRepository.save(url);
        return shortUrl;
    }

    public Optional<String> resolve(String shortUrl) {
        // Fallback to PostgreSQL
        return urlRepository.findByShortUrl(shortUrl).map(URL::getLongUrl);
    }
}
