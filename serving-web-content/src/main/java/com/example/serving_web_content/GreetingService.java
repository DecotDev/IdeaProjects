package com.example.serving_web_content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {
    @Autowired
    List<String> msgs;

    public void addWord(String w) {
        msgs.add(w);
    }

    public List<String> getAll() {
        return msgs;
    }

}
