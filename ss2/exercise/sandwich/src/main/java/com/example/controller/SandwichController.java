package com.example.controller;

import com.example.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @Autowired
    private ISandwichService iSandwichService;

    @RequestMapping("/save")
    public String save(@RequestParam("condimentInput") String[] condiment,
                       Model model) {
        model.addAttribute("condimentsChosen", condiment);
        model.addAttribute("condiments", this.iSandwichService.findAllCondiments());
        return "sandwich";
    }

    @GetMapping("/")
    public String loadPage(Model model) {
        model.addAttribute("condiments", this.iSandwichService.findAllCondiments());
        return "sandwich";
    }
}
