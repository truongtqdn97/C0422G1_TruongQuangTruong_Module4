package com.example.controller;

import com.example.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping("/")
    public String goHome(){
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam String operator,
                            String num1,
                            String num2,
                            Model model){
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("result", this.iCalculatorService.calculate(num1, num2, operator));
        return "calculator";
    }
}
