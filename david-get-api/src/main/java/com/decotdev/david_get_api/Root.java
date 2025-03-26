package com.decotdev.david_get_api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root{
    public List<Question> results;
    public int response_code;

    public List<Question> getQuestions() {
        return results;
    }
}
