package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.IBlogService;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;


@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showList(Model model,
                           @RequestParam(defaultValue = "0") int idCate,
                           @RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "") String searchName) {
        Pageable pageable = PageRequest.of(page, 3, Sort.by("date").descending());
        Page<Blog> blogPage;
        Category category = null;
        if (idCate == 0) {
            blogPage = blogService.displayAllBlog(searchName, pageable);
        } else {
//            blogPage = blogService.searchByCategory(pageable,idCate);
            blogPage = blogService.searchByCategoryAndName(searchName, pageable, idCate);
            category = categoryService.getCategory(idCate);
        }
        model.addAttribute("category", category);
        model.addAttribute("blogList", blogPage);
        model.addAttribute("searchName", searchName);
        model.addAttribute("categoryList", categoryService.getAllCategory());
        return "blog/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", categoryService.getAllCategory());
        return "blog/create";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blog.setDate(LocalDateTime.now());
        blogService.createNewBlog(blog);
        redirectAttributes.addFlashAttribute("mess", "Add blog success !");
        return "redirect:/blog";
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam int id) {
        blogService.delete(id);
        return "redirect:/blog";
    }

    @GetMapping("/detail")
    public String showDetail(Model model, int id) {
        model.addAttribute("category", categoryService.getCategory(blogService.getBlog(id).getCategory().getId()));
        model.addAttribute("blog", blogService.getBlog(id));
        return "/blog/detail";
    }

    @GetMapping("/update")
    public String updateForm(int id, Model model) {
        model.addAttribute("blog", blogService.getBlog(id));
        model.addAttribute("categoryList", categoryService.getAllCategory());
        return "/blog/update";
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog) {
        blogService.update(blog);
        return "redirect:/blog";
    }

}