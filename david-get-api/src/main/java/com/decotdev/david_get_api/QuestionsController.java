package com.decotdev.david_get_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(QuestionsController.QUESTIONS)
public class QuestionsController {
    public static final String QUESTIONS = "/questions";

    @Autowired
    QuestionsService service;

    public List<Question> questions(Model model) {
        Question question = QuestionsService.getQuestion();
    }
}
