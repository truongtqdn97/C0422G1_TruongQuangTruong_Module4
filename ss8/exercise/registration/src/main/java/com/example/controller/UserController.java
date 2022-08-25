package com.example.controller;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping(value = "/")
    public String home() {
        return "home";
    }

    @GetMapping(value = "/form")
    public String form(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "form";
    }

    @PostMapping(value = "/register")
    public String register(@ModelAttribute @Valid UserDto userDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           Model model){
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()){
            return "/form";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);

        this.iUserService.save(user);
        redirectAttributes.addFlashAttribute("msg", "Register successfully!");
        return "redirect:/";
    }
}
