package com.codegym.demo_springmvc.controller;

import com.codegym.demo_springmvc.model.Student;
import com.codegym.demo_springmvc.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    // DI bằng field (interface)
    @Autowired
    private IStudentService studentService;

    // DI bằng constructor
//    @Autowired
//    public StudentController(IStudentService studentService) {
//        this.studentService = studentService;
//    }
   /// DI bằng setter
//    @Autowired
//    public void setStudentService(IStudentService studentService) {
//        this.studentService = studentService;
//    }
//    @RequestMapping(value = "/student", method = RequestMethod.GET)
    @GetMapping(value = "/student")
    public String showList(Model model){
        model.addAttribute("studentList", studentService.findAll());
        return "student/list";
    }
    @GetMapping("/student/create")
    public String showForm(){
        return "/student/create";
    }
    @PostMapping("/student/create")
    public String save(@RequestParam int id,
                       @RequestParam String name,
                       Model model){
        Student student = new Student(id,name);
        System.out.println("id"+ id+ "name"+name);
        model.addAttribute("studentList", studentService.findAll());
        return "student/list";
    }
}
