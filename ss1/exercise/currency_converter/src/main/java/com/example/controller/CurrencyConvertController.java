package com.example.controller;

import com.example.service.ICurrencyConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConvertController {
    @Autowired
    private ICurrencyConverterService iCurrencyConverterService;

    @GetMapping
    public String goHome() {
        return "currency_convert";
    }

    @GetMapping("/convert")
    public String returnVnd(@RequestParam double usd, Model model) {
//        double vnd = this.iCurrencyService.convert(usd);
        model.addAttribute("usd", usd);
        model.addAttribute("vnd", this.iCurrencyConverterService.convert(usd));
        return "currency_convert";
    }
}
