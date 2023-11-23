package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.IBlogService;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public String displayBlog(@PageableDefault(size = 2, sort = "createTime") Pageable pageable, Model model) {
        model.addAttribute("blogs", blogService.getBlog(pageable));
        model.addAttribute("categorys", categoryService.getCategory());
        return "home";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categorys", categoryService.getCategory());
        return "create";
    }

    @PostMapping("/save")
    public String saveBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blog.setCreateTime(LocalDateTime.now());
        blogService.createBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Một blog đã được thêm mới");
        return "redirect:/blog";
    }

    @GetMapping("/detail/{id}")
    public String detailBlog(@PathVariable Integer id, Model model) {
        if (blogService.getBlogDetail(id) == null) {
            model.addAttribute("message", "Không tìm thấy blog nào");
            return "error";
        }
        model.addAttribute("categorys", categoryService.getCategory());
        model.addAttribute("blog", blogService.getBlogDetail(id));
        return "detail";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable Integer id, Model model) {
        if (blogService.getBlogDetail(id) == null) {
            model.addAttribute("message", "Không tìm thấy blog nào");
            return "error";
        }
        model.addAttribute("categorys", categoryService.getCategory());
        model.addAttribute("blog", blogService.getBlogDetail(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes attributes, Model model) {
        if (blogService.getBlogDetail(blog.getId()) == null) {
            model.addAttribute("message", "Không Tìm Thấy Blog nào");
            return "error";
        }
        blogService.update(blog);
        attributes.addFlashAttribute("message", "Blog đã được cập nhật");
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String remove(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        if (blogService.getBlogDetail(id) == null) {
            model.addAttribute("message", "Không tìm thấy Blog nào");
        }
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Thành Công!Blog đã được xóa");
        return "redirect:/blog";
    }

    @GetMapping("/category/{id}")
    public String getListBlog(@PathVariable Integer id, Model model, Pageable pageable) {
        if (blogService.getBlogDetail(id) == null) {
            model.addAttribute(model.addAttribute("message", "Không Tìm Thấy Blog nào"));
            return "error";
        }
        model.addAttribute("blogs", blogService.getAllBlogByCategoryID(id, pageable));
        model.addAttribute("categorys", categoryService.getCategory());
        return "/home";
    }

    @GetMapping("/search")
    public String search(@RequestParam("search") String search, Model model, Pageable pageable) {
        model.addAttribute("blogs", blogService.search(search, pageable));
        return "/home";
    }
}
