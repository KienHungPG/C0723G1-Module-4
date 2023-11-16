package com.codegym.ex1.service;

import com.codegym.ex1.model.Email;
import com.codegym.ex1.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService{
    @Autowired
    private IEmailRepository emailRepository;

    @Override
    public List<String> getLanguages() {
        return emailRepository.getLanguages();
    }

    @Override
    public List<Integer> getPageSize() {
        return emailRepository.getPageSize();
    }

    @Override
    public Email getEmail() {
        return emailRepository.getEmail();
    }
}
