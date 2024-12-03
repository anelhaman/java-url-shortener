package com.example.urlshortener.dto;

public class URLRequest {
    private String url;

    // Constructor
    public URLRequest(String url) {
        this.url = url;
    }

    // Getter and Setter
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
