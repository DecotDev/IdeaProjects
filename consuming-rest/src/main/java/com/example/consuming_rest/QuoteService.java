package com.example.consuming_rest;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QuoteService {

    RestTemplate restTemplate = new RestTemplate();

    public String getQuote() {
        Quote q = restTemplate.getForObject("https://api.chucknorris.io/jokes/random", Quote.class);
        return q.value();
    }
}
