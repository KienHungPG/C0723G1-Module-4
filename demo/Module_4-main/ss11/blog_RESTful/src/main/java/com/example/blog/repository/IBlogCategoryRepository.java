package com.example.blog.repository;

import com.example.blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogCategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllByFlagDeleteFalse();

    boolean existsCategoryById(Integer id);
}
