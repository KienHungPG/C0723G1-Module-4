package com.codegym.ex1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping
public class ConvertController {
    @GetMapping("/convert")
    public String displayHome(){
        return ("convert");
    }
    @PostMapping("/convert")
    public String currencyConvertion(@RequestParam double rate, double usd, Model model){
        double result = rate*usd;
        model.addAttribute("result",result);
        return "convert";
    }

}
