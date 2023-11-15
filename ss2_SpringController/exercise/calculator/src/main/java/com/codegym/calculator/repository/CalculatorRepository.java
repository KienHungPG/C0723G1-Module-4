package com.codegym.calculator.repository;

import org.springframework.stereotype.Repository;

@Repository
public class CalculatorRepository implements ICalculatorRepository{
    @Override
    public String calculator(String calculator, double num1, double num2) {
        String result = "";
        switch (calculator){
            case "addition":
                result = String.valueOf(num1+num2);
                break;
            case "subtraction":
                result = String.valueOf(num1-num2);
                break;
            case "multiplication":
                result = String.valueOf(num1*num2);
                break;
            case "division":
                if (num2 == 0){
                    result = "Cannot be divided by 0";
                }else {
                    result = String.valueOf(num1/num2);
                }
                break;
        }
        return result;
    }
}
