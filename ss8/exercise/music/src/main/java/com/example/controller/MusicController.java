package com.example.controller;

import com.example.dto.MusicDto;
import com.example.model.Music;
import com.example.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class MusicController {
    @Autowired
    private IMusicService iMusicService;

    @GetMapping(value = "/")
    public String home(Model model,
                       @PageableDefault(value = 2) Pageable pageable){
        model.addAttribute("musicList", this.iMusicService.findAll(pageable));
        return "home";
    }

    @GetMapping(value = "/form")
    public String form(Model model){
        model.addAttribute("musicDto", new MusicDto());
        return "form";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute @Valid MusicDto musicDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "form";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        this.iMusicService.save(music);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/";
    }

    @GetMapping(value = "/update/{id}")
    public String showUpdate(@PathVariable int id,
                             Model model){
        model.addAttribute("musicDto", this.iMusicService.findById(id));
        return "update";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute @Valid MusicDto musicDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "form";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        this.iMusicService.save(music);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/";
    }
}
