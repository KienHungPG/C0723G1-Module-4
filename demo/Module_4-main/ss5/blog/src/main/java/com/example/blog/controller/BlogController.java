package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String getAllBlog(Model model) {
        model.addAttribute("blog", this.blogService.getBlog());
        return "/list";
    }

    @GetMapping("{id}")
    public String getDetailsBlog(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            redirectAttributes.addFlashAttribute("message", "Not Found Id");
            return "redirect:/blogs";
        } else {
            model.addAttribute("blog", blog);
            return "/details";
        }
    }

    @GetMapping("/create-form")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create-form";
    }

    @PostMapping()
    public String createNewBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blog.setDateWriting(LocalDateTime.now());
        blogService.createBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Create Success");
        return "redirect:/blogs";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (blogService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Not Found Id");
            return "redirect:/blogs";
        } else {
            blogService.delete(id);
            redirectAttributes.addFlashAttribute("message", "Delete Success");
            return "redirect:/blogs";
        }
    }

    @GetMapping("edit/{id}")
    public String editFormBlog(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            redirectAttributes.addFlashAttribute("message", "Not Found Id");
            return "redirect:/blogs";
        } else {
            model.addAttribute("blog", blog);
            return "/edit";
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blog.setDateWriting(LocalDateTime.now());
        blogService.update(blog);
        redirectAttributes.addFlashAttribute("message", "Update Success");
        return "redirect:/blogs";
    }
}
