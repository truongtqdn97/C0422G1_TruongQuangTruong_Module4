package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import com.example.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@CrossOrigin
@Controller
@RequestMapping(value = "/blogs")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired ICategoryService iCategoryService;

    @GetMapping(value = "/{id}")
    public String viewBlog(@PathVariable int id,
                           Model model) {
        model.addAttribute("categories", this.iCategoryService.findAll());
        model.addAttribute("blogObj", this.iBlogService.findById(id));
        return "detail";
    }

    @GetMapping(value = "/list")
    public String viewBlogList(@RequestParam(defaultValue = "") String topic,
                               @PageableDefault(size = 5) Pageable pageable,
                               Model model,
                               Principal principal) {
        Page<Blog> blogPage = this.iBlogService.findAllByTopic(topic, pageable);
        model.addAttribute("blogList", blogPage);
        model.addAttribute("categories", this.iCategoryService.findAll());
        if (principal == null){
            return "list";
        }
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        model.addAttribute("userInfo", loginedUser.getAuthorities());
        return "list";
    }

    @GetMapping(value = "/showForm")
    public String viewForm(Model model){
        model.addAttribute("categories", this.iCategoryService.findAll());
        model.addAttribute("blogObj", new Blog());
        return "form";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute Blog blog,
                         RedirectAttributes redirectAttributes){
        this.iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("msg", "Create successfully!");
        return "redirect:/blogs/list";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id,
                           Model model){
        model.addAttribute("blogObj", this.iBlogService.findById(id));
        model.addAttribute("categories", this.iCategoryService.findAll());
        return "update";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog,
                       RedirectAttributes redirectAttributes){
        this.iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("msg", "Update successfully!");
        return "redirect:/blogs/list";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam int removeId,
                         RedirectAttributes redirectAttributes){
        this.iBlogService.remove(removeId);
        redirectAttributes.addFlashAttribute("msg", "Delete successfully!");
        return "redirect:/blogs/list";
    }
}
