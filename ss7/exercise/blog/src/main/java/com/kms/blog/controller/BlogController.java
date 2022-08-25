package com.kms.blog.controller;

import com.kms.blog.model.Blog;
import com.kms.blog.model.Category;
import com.kms.blog.service.IBlogService;
import com.kms.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/")
    public String view(@RequestParam(defaultValue = "") String searchTopic,
                       @RequestParam(defaultValue = "") String categoryVar,
                       @PageableDefault(size = 2, sort = "bTime", direction = Sort.Direction.DESC) Pageable pageable,
                       Model model){
//        String searchTopicValue = searchTopic.orElse("");
//        String categoryValue = categoryVar.orElse("");
            model.addAttribute("blogList",
                    this.iBlogService.findByCategory(searchTopic, categoryVar, pageable));

        model.addAttribute("categories", this.iCategoryService.findAll());
        model.addAttribute("searchTopic", searchTopic);
        return "view";
    }

    @GetMapping("/showForm")
    public String showForm(Model model){
        model.addAttribute("blogObj", new Blog());
        model.addAttribute("categories", this.iCategoryService.findAll());
        return "form";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog,
                         RedirectAttributes redirectAttributes){
        blog.setbTime(LocalDateTime.now());
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
        model.addAttribute("categories", this.iCategoryService.findAll());
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
