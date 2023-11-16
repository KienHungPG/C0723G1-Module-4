package com.codegym.ex1.controller;

import com.codegym.ex1.model.Email;
import com.codegym.ex1.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("email")
public class EmailController {
    @Autowired
    private IEmailService emailService;

    @GetMapping("setting")
    public String showFormSettings(@ModelAttribute Email email, Model model){
        List<String> listLanguages = emailService.getLanguages();
        List<Integer> listPageSize = emailService.getPageSize();
        model.addAttribute("email",email);
        model.addAttribute("languages",listLanguages);
        model.addAttribute("pageSize",listPageSize);
        return "setting";
    }
    @GetMapping
    public String showDetail(Model model){
        Email email = emailService.getEmail();
        model.addAttribute("email",email);
        return "detail";
    }

    @PostMapping("save")
    public String saveEmail(@ModelAttribute Email email,Model model){
        model.addAttribute("email",email);
        return "detail";
    }
}
