package com.example.quan_li_san_pham.controller;

import com.example.quan_li_san_pham.model.Product;
import com.example.quan_li_san_pham.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String getAllProduct(Model model) {
        model.addAttribute("products", this.iProductService.getProduct());
        return "/list";
    }

    @GetMapping("{id}")
    public String getDetailsProduct(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        Product product = iProductService.findById(id);
        if (product == null) {
            redirectAttributes.addFlashAttribute("message", "Not Found Id");
            return "redirect:/products";
        } else {
            model.addAttribute("products", product);
            return "/details";
        }
    }

    @GetMapping("/create-form")
    public String showFormCreate(Model model) {
        model.addAttribute("products", new Product());
        return "/create-form";
    }

    @PostMapping()
    public String createNewProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        iProductService.createProduct(product);
        redirectAttributes.addFlashAttribute("message", "Create Success");
        return "redirect:/products";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes, Model model) {
        if (iProductService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Not Found Id");
            return "redirect:/products";
        } else {
            iProductService.delete(id);
            redirectAttributes.addFlashAttribute("message", "Delete Success");
            return "redirect:/products";
        }
    }

    @GetMapping("edit/{id}")
    public String editFormProduct(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        Product product = iProductService.findById(id);
        if (product == null) {
            redirectAttributes.addFlashAttribute("message", "Not Found Id");
            return "redirect:/products";
        } else {
            model.addAttribute("product", product);
            return "/edit";
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        iProductService.update(product);
        redirectAttributes.addFlashAttribute("message", "Update Success");
        return "redirect:/products";
    }

    @PostMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        List<Product> product = iProductService.findByName(name);
        if (product.size() == 0) {
            return "redirect:/products";
        } else {
            model.addAttribute("products", product);
            return "/list";
        }
    }
}
