package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConvertController {

    @GetMapping("/")
    public String getUsd(){
        return "/currencyConvert";
    }


    @GetMapping("/convert")
    public String returnVnd(@RequestParam double usd, Model model){
        model.addAttribute("usd", usd);
        model.addAttribute("vnd", (usd*23000));
        return "/currencyConvert";
    }


}
