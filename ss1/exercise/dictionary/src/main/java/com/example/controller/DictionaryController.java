package com.example.controller;

import com.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService iDictionaryService;

    @GetMapping("/")
    public String goHome(){
        return "dictionary";
    }

    @GetMapping("/translate")
    public String translate(@RequestParam String eng, Model model){
        model.addAttribute("eng", eng);
        model.addAttribute("vie", this.iDictionaryService.translate(eng));
        return "dictionary";
    }
}
