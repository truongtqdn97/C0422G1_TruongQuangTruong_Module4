package com.example.controller;

import com.example.model.Email;
import com.example.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailController {
    @Autowired
    private IEmailService iEmailService;

    @GetMapping("/")
    public String goHome(Model model){
        model.addAttribute("languagesList", this.iEmailService.showListLanguages());
        model.addAttribute("pageSizesList", this.iEmailService.showListPageSizes());
        model.addAttribute("email", new Email());
        return "home";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Email email,
                         RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("email", email);
        return "success";
    }
}
