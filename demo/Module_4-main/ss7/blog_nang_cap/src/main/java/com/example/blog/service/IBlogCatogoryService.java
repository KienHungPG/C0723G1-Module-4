package com.example.blog.service;

import com.example.blog.model.Category;

import java.util.List;

public interface IBlogCatogoryService {
    List<Category> getCategory();

    Category getCategoryById(Integer id);

    boolean remove(Integer id);

    void update(Category category);

    void save(Category category);
}
