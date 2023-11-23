package com.example.calculator.controller;

import com.example.calculator.service.impl.CalculatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("index")
public class CalculatorController {
    @Autowired
    private CalculatorServiceImpl calculatorService;

    @GetMapping
    public String index() {
        return "index";
    }

    @PostMapping("/calculator")
    public String addition(@RequestParam(value = "calculator") String calculator,
                           @RequestParam("num1") double num1, @RequestParam("num2") double num2, Model model) {
        model.addAttribute("result", calculatorService.calculator(calculator, num1, num2));
        return "index";
    }
}
