package com.codegym.ex2.controller;

import com.codegym.ex2.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {

    @Autowired
    private IDictionaryService dictionaryService;
    @GetMapping
    public String index(){
        return "index";
    }
    @PostMapping("/dictionary")
    public String dictionary(@RequestParam String text, Model model){
        model.addAttribute("result",dictionaryService.getDictionary(text));
        return "index";
    }
}
