package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogCatogoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private IBlogCatogoryService categoryService;

    @GetMapping()
    public String showFormCategoryManagement(Model model) {
        model.addAttribute("categorys", categoryService.getCategory());
        return "category";
    }

    @GetMapping("/delete/{id}")
    public String remove(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {

        if (categoryService.getCategoryById(id) == null) {
            model.addAttribute("message", "Not Found Category");
        }
        categoryService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete Successful");
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable Integer id, Model model) {
        if (categoryService.getCategoryById(id) == null) {
            model.addAttribute("message", "Không tìm thấy chủ đề nào");
            return "error";
        }
        model.addAttribute("category", categoryService.getCategoryById(id));
        return "edit_category";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Category category, RedirectAttributes attributes, Model model) {
        if (categoryService.getCategoryById(category.getId()) == null) {
            model.addAttribute("message", "Không tìm thấy chủ đề nào");
            return "error";
        }
        categoryService.update(category);
        attributes.addFlashAttribute("message", "Chủ đề đã được cập nhật");
        return "redirect:/category";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("category", new Category());
        return "create_category";
    }

    @PostMapping("/create")
    public String saveCategory(@ModelAttribute("category") Category category, RedirectAttributes attributes) {
        categoryService.save(category);
        attributes.addFlashAttribute("message", "Create Successful");
        return "redirect:/category";
    }
}
