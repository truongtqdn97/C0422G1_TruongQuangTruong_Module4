package com.example.controller;

import com.example.dto.MusicDto;
import com.example.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        model.addAttribute("MusicDto", new MusicDto());
        return "form";
    }
}
