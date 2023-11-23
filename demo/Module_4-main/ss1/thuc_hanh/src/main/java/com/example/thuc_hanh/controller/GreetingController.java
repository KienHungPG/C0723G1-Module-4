package com.example.thuc_hanh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @GetMapping("/greeting")
    public String gretting(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
}
