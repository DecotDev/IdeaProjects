package com.decotdev.david_get_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(QuestionsController.QUESTIONS)
public class QuestionsController {
    public static final String QUESTIONS = "/questions";

    @Autowired
    QuestionsService service;

    @GetMapping
    public String questions(Model model) {
        Root root = service.getRoot();

        model.addAttribute("questions", root.getQuestions());
        return "questions";
    }
}
