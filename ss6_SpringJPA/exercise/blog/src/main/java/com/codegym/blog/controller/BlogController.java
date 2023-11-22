package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping
    public String getAllBlogs(Model model){
        model.addAttribute("blog",blogService.getBlog());
        return "/list";
    }
    @GetMapping("{id}")
    public String getDetailBlog(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes){
        Blog blog = blogService.findById(id);
        if (blog == null){
            redirectAttributes.addFlashAttribute("message", "Not Found");
            return "redirect:/blogs";
        }else {
            model.addAttribute("blog",blog);
            return "/detail";
        }
    }
    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping()
    public String createNewBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blog.setTimeWriting(LocalDateTime.now());
        blogService.createBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Create Success");
        return "redirect:/blogs";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (blogService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Not Found");
        } else {
            blogService.delete(id);
            redirectAttributes.addFlashAttribute("message", "Delete Success");
        }
        return "redirect:/blogs";
    }

    @GetMapping("edit/{id}")
    public String editFormBlog(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            redirectAttributes.addFlashAttribute("message", "Not Found");
            return "redirect:/blogs";
        } else {
            model.addAttribute("blog", blog);
            return "/edit";
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.update(blog);
        redirectAttributes.addFlashAttribute("message", "Update Success");
        return "redirect:/blogs";
    }
}

