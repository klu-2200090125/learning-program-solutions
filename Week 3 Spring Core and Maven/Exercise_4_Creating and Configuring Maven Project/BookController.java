package com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to the Library Management Application!");
        return "home";
    }
}
