package com.codegym.practice2.controller;

import com.codegym.practice2.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/customers")
    public String showList(Model model) {
        model.addAttribute("customerList",customerService.findAll());
        return "/list";
    }
}
