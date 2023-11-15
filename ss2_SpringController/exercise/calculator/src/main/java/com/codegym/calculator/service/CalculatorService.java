package com.codegym.calculator.service;

import com.codegym.calculator.repository.ICalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService{
    @Autowired
    private ICalculatorRepository calculatorRepository;
    @Override
    public String calculator(String calculator, double num1, double num2) {
        return calculatorRepository.calculator(calculator,num1,num2);
    }
}
