package com.example.cart.comtroller;

import com.example.cart.model.Cart;
import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Optional;


@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart initCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public String showShop(Model model) {
        model.addAttribute("product", this.productService.findAll());
        return "/shop";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, RedirectAttributes redirectAttributes,
                            @ModelAttribute Cart cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            redirectAttributes.addFlashAttribute("msg", "Not Found Product");
            return "/404";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shopping-cart";
    }

    @GetMapping("/down/{id}")
    public String downCart(@PathVariable Long id, RedirectAttributes redirectAttributes,
                            @ModelAttribute Cart cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            redirectAttributes.addFlashAttribute("msg", "Not Found Product");
            return "/404";
        }
        cart.downProduct(productOptional.get());
        return "redirect:/shopping-cart";
    }

    @GetMapping("/details/{id}")
    public String detailProduct(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
        Product product = productService.findById(id).get();
        if (product == null) {
            redirectAttributes.addFlashAttribute("msg", "Not Found Product");
            return "/404";
        }
        model.addAttribute("product", product);
        return "details";
    }

    @GetMapping("/delete/{id}")
    public String delete(@ModelAttribute Cart cart,@PathVariable Long id,RedirectAttributes redirectAttributes,Model model){
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            redirectAttributes.addFlashAttribute("msg", "Not Found Product");
            return "/404";
        }
        cart.removeCart(productOptional.get());
        return "redirect:/shopping-cart";
    }
}
