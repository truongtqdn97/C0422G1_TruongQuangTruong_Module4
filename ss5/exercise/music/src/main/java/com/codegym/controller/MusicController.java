package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.model.MusicForm;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
@PropertySource("classpath:upload_file.properties")
public class MusicController {
    @Autowired
    private IMusicService iMusicService;

    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping("/")
    public String view(Model model){
        model.addAttribute("musicList", this.iMusicService.findAll());
        return "view";
    }

    //ko dung path variable
    @GetMapping("/detail")
    public String detail(@RequestParam int id,
                         Model model){
        model.addAttribute("musicObj", this.iMusicService.findById(id));
        return "detail";
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("music", new MusicForm());
        return "form";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute MusicForm musicForm,
                         Model model){
        MultipartFile multipartFile = musicForm.getPath();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(musicForm.getPath().getBytes(),
                    new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Music music = new Music(musicForm.getId(), musicForm.getName(), musicForm.getSinger(),
                musicForm.getType(), fileName);
        this.iMusicService.save(music);
        model.addAttribute("msg", "Create successfully!");
        model.addAttribute("musicList",
                this.iMusicService.findAll());
        return "view";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam int removeId,
                         RedirectAttributes redirectAttributes){
        this.iMusicService.remove(removeId);
        redirectAttributes.addFlashAttribute("msg","Delete completely!");
        return "redirect:/";
    }

    //dung path variable
    @GetMapping("/update/{mId}")
    public String updateForm(@PathVariable int mId, Model model){
        model.addAttribute("music", this.iMusicService.findById(mId));
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Music music,
                         RedirectAttributes redirectAttributes){
        this.iMusicService.update(music);
        redirectAttributes.addFlashAttribute("msg", "Update completely!");
        return "redirect:/";
    }
}
