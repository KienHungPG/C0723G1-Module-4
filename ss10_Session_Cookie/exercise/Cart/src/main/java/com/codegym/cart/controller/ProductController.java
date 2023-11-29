package com.codegym.cart.controller;

import com.codegym.cart.model.Cart;
import com.codegym.cart.model.Product;
import com.codegym.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart getProduct() {
        return new Cart();
    }

    @GetMapping("")
    private String displayListProducts(Model model,Cart cart) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("cart",cart);
        return "/shop";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable int id, @ModelAttribute("cart") Cart cart, Model model,
                            RedirectAttributes redirectAttributes) {
        Product product = productService.findById(id);
        if (product == null) {
            model.addAttribute("message", "Product not exist");
            return "error";
        }
        cart.addProduct(product);
        redirectAttributes.addFlashAttribute("message", "Add " + product.getName() + " to cart successfully");
        return "redirect:/products";
    }
    @GetMapping("/detail/{id}")
    public String detailProduct(@PathVariable int id,Model model,@ModelAttribute Cart cart){
        model.addAttribute("product",productService.findById(id));
        model.addAttribute("cart",cart);
        return "/detail";
    }
}
