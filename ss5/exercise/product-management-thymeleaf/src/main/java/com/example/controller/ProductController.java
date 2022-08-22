package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("/")
    public String view(Model model, String nameSearch) {
        model.addAttribute("productList", this.iProductService.showProductList(nameSearch));
        return "view";
    }

    @GetMapping("/detail/{pId}")
    public String showDetail(@PathVariable int pId, Model model) {
        model.addAttribute("productObj", this.iProductService.findById(pId));
        return "detail";
    }

    @GetMapping("/showCreateForm")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product,
                         RedirectAttributes redirectAttributes) {
        this.iProductService.save(product);
        redirectAttributes.addFlashAttribute("msg", "Create successfully!");
        return "redirect:/";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam int removeId,
                         RedirectAttributes redirectAttributes) {
        this.iProductService.remove(removeId);
        redirectAttributes.addFlashAttribute("msg", "Delete successfully!");
        return "redirect:/";
    }

    @GetMapping("/update/{pId}")
    public String updateForm(@PathVariable int pId,
                             Model model) {
        model.addAttribute("productObj", this.iProductService.findById(pId));
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product,
                         RedirectAttributes redirectAttributes) {
        this.iProductService.update(product);
        redirectAttributes.addFlashAttribute("msg", "Update successfully!");
        return "redirect:/";
    }

//    @GetMapping("/search")
//    public String search(@RequestParam String nameSearch, Model model) {
//        model.addAttribute("productList", this.iProductService.showProductList(nameSearch));
//        return "view";
//    }
}
