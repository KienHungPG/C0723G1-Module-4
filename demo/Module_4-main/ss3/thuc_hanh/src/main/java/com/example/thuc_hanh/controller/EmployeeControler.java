package com.example.thuc_hanh.controller;

import com.example.thuc_hanh.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("views/")
public class EmployeeControler {
    @GetMapping()
    public String showForm(Model modelMap) {
        modelMap.addAttribute("employee", new Employee());
        return "create";
    }

    @PostMapping("/addEmployee")
    public String submit(@ModelAttribute("employee") Employee employee, Model modelMap) {
        modelMap.addAttribute("name", employee.getName());
        modelMap.addAttribute("contactNumber", employee.getContactNumber());
        modelMap.addAttribute("id", employee.getId());
        return "info";
    }
}
