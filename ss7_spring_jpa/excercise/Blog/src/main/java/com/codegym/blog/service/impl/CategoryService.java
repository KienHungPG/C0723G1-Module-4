package com.codegym.blog.service.impl;

import com.codegym.blog.model.Category;
import com.codegym.blog.repository.ICategoryRepository;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> getCategory() {
        return this.categoryRepository.findAllByFlagDeleteIsFalse();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Integer id) {
        this.getCategoryById(id).setFlagDelete(true);
    }

    @Override
    public void update(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void save(Category category) {
        category.setFlagDelete(false);
        categoryRepository.save(category);
    }
}
