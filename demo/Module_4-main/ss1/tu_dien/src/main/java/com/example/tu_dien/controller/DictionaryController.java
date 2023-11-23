package com.example.tu_dien.controller;

import com.example.tu_dien.service.impl.DictionaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DictionaryController {
    @Autowired
    private DictionaryServiceImpl dictionaryService;

    @GetMapping
    public String index() {
        return "index";
    }

    @PostMapping("/dictionary")
    public String dictionary(@RequestParam("text") String text, Model model) {
        model.addAttribute("result", dictionaryService.getDictionary(text));
        return "index";
    }

}
