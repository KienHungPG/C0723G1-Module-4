package com.codegym.blog_plus.service;

import com.codegym.blog_plus.model.Category;

import java.util.List;

public interface IBlogCatogoryService {
    List<Category> getCategory();

    Category getCategoryById(Integer id);

    boolean remove(Integer id);

    void update(Category category);

    void save(Category category);
}
