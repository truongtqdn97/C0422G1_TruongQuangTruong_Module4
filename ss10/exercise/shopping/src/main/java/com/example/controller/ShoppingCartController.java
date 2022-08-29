package com.example.controller;

import com.example.repository.impl.CartRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ShoppingCartController {

    @ModelAttribute("cart")
    public CartRepository setupCart() {
        return new CartRepository();
    }

    @GetMapping("/shopping-cart")
    public String showCart(@SessionAttribute("cart") CartRepository cart,
                           Model model) {
        model.addAttribute("cart", cart);
        return "cart";
    }
}
