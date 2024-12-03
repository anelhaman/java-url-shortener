package com.example.urlshortener.controller;

import com.example.urlshortener.dto.URLRequest;
import com.example.urlshortener.dto.URLResponse;
import com.example.urlshortener.exception.ShortUrlNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.urlshortener.service.URLService;

@Controller
@RequestMapping("/")
public class URLController {
    private final URLService urlService;

    public URLController(URLService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<URLResponse> shortenURL(@RequestBody URLRequest request) {
        String shortUrl = urlService.shorten(request.getUrl());
        return ResponseEntity.ok(new URLResponse(shortUrl));
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Void> redirectURL(@PathVariable String shortUrl) {
        String longUrl = urlService.resolve(shortUrl)
                .orElseThrow(() -> new ShortUrlNotFoundException("Short URL not found: " + shortUrl));

        return ResponseEntity.status(301).header("Location", longUrl).build();
    }

}
