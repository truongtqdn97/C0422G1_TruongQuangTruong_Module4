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
                            double num1,
                            double num2,
                            Model model){
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        switch (operator){
            case "add":
                model.addAttribute("result", this.iCalculatorService.add(num1, num2));
                break;
            case "subtract":
                model.addAttribute("result", this.iCalculatorService.subtract(num1, num2));
                break;
            case "multiply":
                model.addAttribute("result", this.iCalculatorService.multiply(num1, num2));
                break;
            case "divide":
                try {
                    model.addAttribute("result", this.iCalculatorService.divide(num1, num2));
                }catch (ArithmeticException e){
                    model.addAttribute("result", e.getMessage());
                }
                break;
        }
        return "calculator";
    }
}
