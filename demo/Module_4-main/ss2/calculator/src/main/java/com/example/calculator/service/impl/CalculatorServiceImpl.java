package com.example.calculator.service.impl;

import com.example.calculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService {
    @Override
    public String calculator(String calculator, double num1, double num2) {
        String result = "";
        switch (calculator) {
            case "addition":
                result = String.valueOf(num1 + num2);
                break;
            case "subtraction":
                result = String.valueOf(num1 - num2);
                break;
            case "multiplication":
                result = String.valueOf(num1 * num2);
                break;
            case "division":
                if (num2 == 0) {
                    return "Not Divide 0";
                } else {
                    result = String.valueOf(num1 / num2);
                }
                break;
        }
        return result;
    }


}
