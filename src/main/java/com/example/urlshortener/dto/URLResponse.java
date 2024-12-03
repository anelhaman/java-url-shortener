package com.example.urlshortener.dto;

public class URLResponse {
    private String shortUrl;

    // Constructor
    public URLResponse(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    // Getter
    public String getShortUrl() {
        return shortUrl;
    }

    // Setter (optional, if needed)
    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}