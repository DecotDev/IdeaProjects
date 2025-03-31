package com.decotdev.david_get_api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/questions")
public class QuestionsController {
    private final QuestionsService service;

    public QuestionsController(QuestionsService service) {
        this.service = service;
    }

    @GetMapping
    public String showQuestions(Model model) {
        model.addAttribute("questions", service.getQuestions());
        return "questions";
    }

    @PostMapping("/answer")
    public String checkAnswer(@RequestParam String questionText, @RequestParam String selectedAnswer, Model model) {
        boolean isCorrect = service.checkAnswer(questionText, selectedAnswer);
        model.addAttribute("questions", service.getQuestions());
        model.addAttribute("answeredQuestion", questionText);
        model.addAttribute("isCorrect", isCorrect);
        return "questions";
    }
}
