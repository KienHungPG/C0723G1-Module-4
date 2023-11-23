package com.example.thu_dien_tu.service;

import com.example.thu_dien_tu.model.Email;

import java.util.List;

public interface IEmailService {
    List<String> getLanguages();

    List<Integer> getPageSize();
    public Email getEmail();
}
