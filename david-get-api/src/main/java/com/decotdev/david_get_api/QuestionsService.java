package com.decotdev.david_get_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class QuestionsService {

    RestTemplate restTemplate = new RestTemplate();

    public List<Question> getQuestion() {
         = restTemplate.getForObject("https://opentdb.com/api.php?amount=10&category=15", Question.class)
        return question
    }
}
