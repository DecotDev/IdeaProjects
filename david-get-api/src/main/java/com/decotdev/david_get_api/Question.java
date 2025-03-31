package com.decotdev.david_get_api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {

    private String difficulty;
    private String category;

    @JsonProperty("question")
    private String questionText;

    @JsonProperty("correct_answer")
    private String correctAnswer;

    @JsonProperty("incorrect_answers")
    private List<String> incorrectAnswers;

    private List<String> shuffledAnswers;

    public void shuffleAnswers() {
        shuffledAnswers = new ArrayList<>(incorrectAnswers);
        shuffledAnswers.add(correctAnswer);
        Collections.shuffle(shuffledAnswers);
    }

    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getQuestionText() { return questionText; }
    public void setQuestionText(String questionText) { this.questionText = questionText; }

    public String getCorrectAnswer() { return correctAnswer; }
    public void setCorrectAnswer(String correctAnswer) { this.correctAnswer = correctAnswer; }

    public List<String> getIncorrectAnswers() { return incorrectAnswers; }
    public void setIncorrectAnswers(List<String> incorrectAnswers) { this.incorrectAnswers = incorrectAnswers; }

    public List<String> getShuffledAnswers() { return shuffledAnswers; }
}
