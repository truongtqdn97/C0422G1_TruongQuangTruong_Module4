package com.example.Controller;

import com.example.model.Cart;
import com.example.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ShoppingCartController {
    @Autowired
    private ICartService iCartService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

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
}
