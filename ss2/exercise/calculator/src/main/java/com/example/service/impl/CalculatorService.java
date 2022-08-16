package com.example.service.impl;

import com.example.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String calculate(String num1, String num2, String operator) {
        if (num1.equals("") || num2.equals("")) {
            return "Math error";
        }
        if (Double.parseDouble(num2) == 0) {
            return "Math error";
        }
        switch (operator) {
            case "add":
                return String.valueOf(Double.parseDouble(num1)+Double.parseDouble(num2));
            case "subtract":
                return String.valueOf(Double.parseDouble(num1)-Double.parseDouble(num2));
            case "multiply":
                return String.valueOf(Double.parseDouble(num1)*Double.parseDouble(num2));
            case "divide":
                return String.valueOf(Double.parseDouble(num1)/Double.parseDouble(num2));
        }
        return "Math error";
    }
}
