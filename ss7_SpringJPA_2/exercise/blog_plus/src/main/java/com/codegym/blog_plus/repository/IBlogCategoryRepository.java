package com.codegym.blog_plus.repository;

import com.codegym.blog_plus.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogCategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllByFlagDeleteFalse();
}
