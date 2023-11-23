package com.example.thu_dien_tu.service.impl;

import com.example.thu_dien_tu.model.Email;
import com.example.thu_dien_tu.repository.IEmailRepository;
import com.example.thu_dien_tu.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService {
    @Autowired
    private IEmailRepository iEmailRepository;

    @Override
    public List<String> getLanguages() {
        return iEmailRepository.getLanguages();
    }

    @Override
    public List<Integer> getPageSize() {
        return iEmailRepository.getPageSize();
    }

    @Override
    public Email getEmail() {
        return iEmailRepository.getEmail();
    }
}
