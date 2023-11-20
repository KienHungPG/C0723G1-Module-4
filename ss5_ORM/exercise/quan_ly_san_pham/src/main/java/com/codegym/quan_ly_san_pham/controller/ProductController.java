package com.codegym.quan_ly_san_pham.controller;

import com.codegym.quan_ly_san_pham.model.Product;
import com.codegym.quan_ly_san_pham.service.IProductService;
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
    private IProductService productService;

    @GetMapping
    private String getAllProduct(Model model){
        model.addAttribute("products",productService.getAll());
        return "/list";
    }
    @GetMapping("{id}")
    public String getDetailsProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("product", this.productService.searchById(id));
        return "/detail";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }
    @PostMapping()
    public String createNewProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.add(product);
        redirectAttributes.addFlashAttribute("message", "Create Success");
        return "redirect:/products";
    }
    @GetMapping("delete/{id}")
    public String deleteProduct(@PathVariable Integer id,RedirectAttributes redirectAttributes) {
        productService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete Success");
        return "redirect:/products";
    }
    @GetMapping("edit/{id}")
    public String editFormProduct(@PathVariable Integer id, Model model,RedirectAttributes redirectAttributes) {
        Product product = productService.searchById(id);
        if (product == null) {
            redirectAttributes.addFlashAttribute("message", "Not Found");
            return "redirect:/";
        } else {
            model.addAttribute("product", product);
            return "/edit";
        }
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Product product,RedirectAttributes redirectAttributes) {
        productService.update(product);
        redirectAttributes.addFlashAttribute("message", "Update Success");
        return "redirect:/products";
    }
    @PostMapping("/search")
    public String search(@RequestParam("name") String name, Model model,RedirectAttributes redirectAttributes) {
        List<Product> product = productService.searchByName(name);
        model.addAttribute("name",name);
        if (product.isEmpty()) {
            redirectAttributes.addFlashAttribute("message","Not found");
            return "redirect:/products";
        } else {
            model.addAttribute("products", product);
            return "/list";
        }
    }
}
