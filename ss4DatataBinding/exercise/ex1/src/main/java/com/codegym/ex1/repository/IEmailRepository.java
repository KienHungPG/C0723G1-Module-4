package com.codegym.ex1.repository;

import com.codegym.ex1.model.Email;

import java.util.List;

public interface IEmailRepository {
    List<String> getLanguages();
    List<Integer> getPageSize();
    public Email getEmail();
}
