package com.codegym.demo_thymeleaf.controller;


import com.codegym.demo_thymeleaf.model.Student;
import com.codegym.demo_thymeleaf.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("/create")
    public String showForm(Model model){
        Student student = new Student();
        model.addAttribute("classList", new String[]{"c05","C06","C07","C08"});
        model.addAttribute("student",student);
        return "/student/create";
    }
    @PostMapping("/create")
    public String save(@ModelAttribute Student student,
                       RedirectAttributes attributes){
        studentService.add(student);
        attributes.addFlashAttribute("mess","add new success");
        return "redirect:/student";
    }
    @GetMapping(value = "")
    public ModelAndView showList(){
//        ModelAndView modelAndView = new ModelAndView("student/list","studentList",studentService.findAll());
        ModelAndView modelAndView = new ModelAndView("student/list");
        modelAndView.addObject("studentList",studentService.findAll());
        return modelAndView;
    }

    @GetMapping("/detail")
    public String detail(@RequestParam(name = "id",required = false,defaultValue = "-1") int detailId, Model model){
        Student student = studentService.findById(detailId);
        model.addAttribute("student",student);
        return "student/detail";
    }
    @GetMapping("/detail2/{id}")
    // có thể regex
//    @GetMapping("/detail2/{id:[1-2]}")
    public String detail2(@PathVariable(name = "id") int detailId, Model model){
        Student student = studentService.findById(detailId);
        model.addAttribute("student",student);
        return "student/detail";
    }
}
