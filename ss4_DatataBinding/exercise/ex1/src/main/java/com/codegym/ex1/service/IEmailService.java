package com.codegym.ex1.service;

import com.codegym.ex1.model.Email;

import java.util.List;

public interface IEmailService {
    List<String> getLanguages();
    List<Integer> getPageSize();
    public Email getEmail();
}
