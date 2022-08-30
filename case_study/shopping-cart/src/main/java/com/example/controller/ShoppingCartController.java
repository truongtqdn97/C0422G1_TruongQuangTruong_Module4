package com.example.controller;

import com.example.model.Cart;
import com.example.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
public class ShoppingCartController {
    @Autowired
    private ICartService iCartService;

    @GetMapping("/shopping-cart")
    public String showCart(@SessionAttribute("cart") Cart cart,
                           Model model) {
        model.addAttribute("cart", cart);
        model.addAttribute("countItemQuantity",
                this.iCartService.countItemQuantity(cart));
        model.addAttribute("countProductQuantity",
                this.iCartService.countProductQuantity(cart));
        model.addAttribute("countTotalPayment",
                this.iCartService.countTotalPayment(cart));

        return "cart";
    }

    @PostMapping(value = "/pay")
    public String pay(@RequestParam Float payInput,
                      @SessionAttribute("cart") Cart cart,
                      Model model) {
        cart.getProducts().clear();
        model.addAttribute("totalPayment", payInput);
        return "payment";
    }
}
