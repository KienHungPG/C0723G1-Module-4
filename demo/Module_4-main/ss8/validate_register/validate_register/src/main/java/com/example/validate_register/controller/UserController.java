package com.example.validate_register.controller;

import com.example.validate_register.dto.UserDto;
import com.example.validate_register.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class UserController {

    @GetMapping("")
    public String showForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/home";
    }

    @PostMapping("/create")
    public String register(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "home";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        model.addAttribute("user", user);
        return "result";
    }
}
