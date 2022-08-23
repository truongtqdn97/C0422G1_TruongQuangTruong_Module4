package com.kms.blog.controller;

import com.kms.blog.model.Blog;
import com.kms.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/")
    public String view(Model model){
        model.addAttribute("blogList", this.iBlogService.findAll());
        return "view";
    }

    @GetMapping("/showForm")
    public String showForm(Model model){
        model.addAttribute("blogObj", new Blog());
        return "form";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog,
                         RedirectAttributes redirectAttributes){
        this.iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("msg", "Create successfully!");
        return "redirect:/";
    }

    @GetMapping("/detail/{bId}")
    public String detail(@PathVariable int bId,
                         Model model){
        model.addAttribute("blogObj", this.iBlogService.findById(bId));
        return "detail";
    }

    @GetMapping("/edit/{bId}")
    public String showEdit(@PathVariable int bId,
                           Model model){
        model.addAttribute("blogObj", this.iBlogService.findById(bId));
        return "update";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog,
                       RedirectAttributes redirectAttributes){
        this.iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("msg", "Update successfully!");
        return "redirect:/";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam int removeId,
                         RedirectAttributes redirectAttributes){
        this.iBlogService.remove(removeId);
        redirectAttributes.addFlashAttribute("msg", "Delete successfully!");
        return "redirect:/";
    }
}
