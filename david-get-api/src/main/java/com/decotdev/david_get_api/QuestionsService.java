package com.decotdev.david_get_api;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class QuestionsService {

    private final RestTemplate restTemplate = new RestTemplate();
    private List<Question> questions = new ArrayList<>();

    public void fetchQuestions() {
        String url = "https://opentdb.com/api.php?amount=5&category=15&type=multiple"; // Get 5 questions
        Root root = restTemplate.getForObject(url, Root.class);
        if (root != null && root.getQuestions() != null) {
            questions = root.getQuestions();
            // Shuffle answer choices for each question
            for (Question q : questions) {
                q.shuffleAnswers();
            }
        }
    }

    public List<Question> getQuestions() {
        if (questions.isEmpty()) {
            fetchQuestions();
        }
        return questions;
    }

    public boolean checkAnswer(String questionText, String answer) {
        return questions.stream()
                .filter(q -> q.getQuestionText().equals(questionText))
                .findFirst()
                .map(q -> q.getCorrectAnswer().equals(answer))
                .orElse(false);
    }
}
