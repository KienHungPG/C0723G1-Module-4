package com.example.blog.service.impl;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.repository.IBlogCategoryRepository;
import com.example.blog.service.IBlogCatogoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogCategoryService implements IBlogCatogoryService {
    @Autowired
    private IBlogCategoryRepository blogCategoryRepository;

    @Override
    public List<Category> getCategory() {
        return this.blogCategoryRepository.findAllByFlagDeleteFalse();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return blogCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public boolean remove(Integer id) {
        Category category = blogCategoryRepository.findById(id).orElse(null);
        if (category != null) {
            category.setFlagDelete(true);
            blogCategoryRepository.save(category);
            return true;
        }
        return false;
    }

    @Override
    public void update(Category category) {
        blogCategoryRepository.save(category);
    }

    @Override
    public void save(Category category) {
        category.setFlagDelete(false);
        blogCategoryRepository.save(category);
    }
}
