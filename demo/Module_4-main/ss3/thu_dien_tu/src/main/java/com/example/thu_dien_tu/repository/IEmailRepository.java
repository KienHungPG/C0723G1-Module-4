package com.example.thu_dien_tu.repository;

import com.example.thu_dien_tu.model.Email;

import java.util.List;

public interface IEmailRepository {
    List<String> getLanguages();
    List<Integer> getPageSize();
    public Email getEmail();
}
