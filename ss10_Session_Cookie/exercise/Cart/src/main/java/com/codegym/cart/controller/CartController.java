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
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private IProductService productService;


    @GetMapping("/shopping-cart")
    public String showCart(@SessionAttribute("cart") Cart cart, Model model) {
        model.addAttribute("cart", cart);
        return "cart";
    }

    @GetMapping("/add/{id}")
    public String addProductInCart(@PathVariable int id, Model model, @SessionAttribute("cart") Cart cart) {
        Product product = productService.findById(id);
        if (product == null) {
            model.addAttribute("message", "Product not exist");
            return "error";
        }
        cart.addProduct(product);
        return "redirect:/cart/shopping-cart";
    }

    @GetMapping("/minus/{id}")
    public String minusProductInCart(@PathVariable int id, Model model, @SessionAttribute("cart") Cart cart) {
        Product product = productService.findById(id);
        if (product == null) {
            model.addAttribute("message", "Product not exist");
            return "error";
        }
        cart.minusProduct(product);
        return "redirect:/cart/shopping-cart";
    }

    @GetMapping("remove/{id}")
    public String removeProduct(@SessionAttribute Cart cart, @PathVariable int id, Model model,
                                RedirectAttributes redirectAttributes) {
        Product product = productService.findById(id);
        if (product == null) {
            model.addAttribute("message", "Product not exist");
            return "error";
        }
        cart.remove(product);
        redirectAttributes.addFlashAttribute("message", "deleted" + product.getName() + "successfully");
        return "redirect:/cart/shopping-cart";
    }

    @GetMapping("/pay")
    public String payCart(RedirectAttributes redirectAttributes, @SessionAttribute Cart cart) {
        cart.destroy();
        redirectAttributes.addFlashAttribute("message", "Payment success");
        return "redirect:/products";
    }

}
