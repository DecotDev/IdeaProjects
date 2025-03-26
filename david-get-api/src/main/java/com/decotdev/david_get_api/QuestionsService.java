package com.decotdev.david_get_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class QuestionsService {

    RestTemplate restTemplate = new RestTemplate();

    public Root getRoot() {
        Root root =  restTemplate.getForObject("https://opentdb.com/api.php?amount=2&category=15&type=multiple", Root.class);
        //System.out.println(root.getQuestions().toString());
        return root;
    }
}
