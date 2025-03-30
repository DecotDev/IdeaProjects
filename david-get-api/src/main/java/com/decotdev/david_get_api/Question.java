package com.decotdev.david_get_api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {

    private String difficulty;
    private String category;

    @JsonProperty("question")  // Ensure JSON field is mapped correctly
    private String questionText;

    @JsonProperty("correct_answer")
    private String correctAnswer;

    @JsonProperty("incorrect_answers")
    private String[] incorrectAnswers;

    // Getters and Setters
    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String[] getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(String[] incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "difficulty='" + difficulty + '\'' +
                ", category='" + category + '\'' +
                ", questionText='" + questionText + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", incorrectAnswers=" + Arrays.toString(incorrectAnswers) +
                '}';
    }
}
