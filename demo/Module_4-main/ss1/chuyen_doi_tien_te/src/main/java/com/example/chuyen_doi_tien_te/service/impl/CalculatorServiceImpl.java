package com.example.chuyen_doi_tien_te.service.impl;

import com.example.chuyen_doi_tien_te.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService {
    @Override
    public Double changeMoney(double money) {
        return money * 26000;
    }
}
