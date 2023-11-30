package com.codegym.blog.service;



import com.codegym.blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategory();

    Category getCategory(int id);
}
