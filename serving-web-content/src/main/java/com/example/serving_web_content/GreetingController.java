package com.example.serving_web_content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(GreetingController.GREETING)
public class GreetingController {
    public final static String GREETING = "/greeting";
    @Value("${welcome-msg}")
    String welcome;

    @Autowired
    GreetingService service;

    @GetMapping()
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        service.addWord(name);
        model.addAttribute("msgs", service.getAll());
        //model.addAttribute("wel", welcome);
        return "greeting";
    }

}