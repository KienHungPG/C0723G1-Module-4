package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogCatogoryService;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private IBlogCatogoryService blogCatogoryService;

    @GetMapping("")
    public String getAllBlog(@PageableDefault(size = 2, sort = "dateWriting", direction = Sort.Direction.ASC) Pageable pageable, Model model) {
        model.addAttribute("blog", this.blogService.findAllByStatusFalse(pageable));
        model.addAttribute("categorys", this.blogCatogoryService.getCategory());
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

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categorys", this.blogCatogoryService.getCategory());
        return "/create";
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
            model.addAttribute("categorys", this.blogCatogoryService.getCategory());
            return "/edit";
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.update(blog);
        redirectAttributes.addFlashAttribute("message", "Update Success");
        return "redirect:/blogs";
    }

    @GetMapping("/search")
    public String seach(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.ASC)
                                Pageable pageable, @RequestParam("title") String title, Model model) {
        model.addAttribute("blog", this.blogService.findAllByTitle(pageable, title));
        model.addAttribute("categorys", this.blogCatogoryService.getCategory());
        return "/list";
    }

    @GetMapping("/category/{id}")
    public String findAllByCategory(@PathVariable Integer id, @PageableDefault(size = 2) Pageable pageable, Model model,
                                    RedirectAttributes redirectAttributes) {
        if (blogService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Not Found Id");
        }
        model.addAttribute("blog", blogService.findAllBlogByCategoryID(id, pageable));
        model.addAttribute("categorys", blogCatogoryService.getCategory());
        return "/list";
    }

}
