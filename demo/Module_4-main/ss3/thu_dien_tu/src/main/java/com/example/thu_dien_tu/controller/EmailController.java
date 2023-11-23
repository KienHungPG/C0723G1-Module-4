package com.example.thu_dien_tu.controller;

import com.example.thu_dien_tu.model.Email;
import com.example.thu_dien_tu.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private IEmailService iEmailService;

    @GetMapping("/setting")
    public String showFormSetting(@ModelAttribute Email email, Model model){
        List<String> listLanguages = iEmailService.getLanguages();
        List<Integer> listPageSize = iEmailService.getPageSize();
        model.addAttribute("email",email);
        model.addAttribute("languages",listLanguages);
        model.addAttribute("pageSize",listPageSize);
        return "form-setting";
    }

    @GetMapping
    public String showDetail(Model model) {
        Email email = iEmailService.getEmail();
        model.addAttribute("email", email);
        return "info";
    }

    @PostMapping("save")
    public String saveEmail (@ModelAttribute Email email, Model model){
        model.addAttribute("email",email);
        return "info";
    }
}
