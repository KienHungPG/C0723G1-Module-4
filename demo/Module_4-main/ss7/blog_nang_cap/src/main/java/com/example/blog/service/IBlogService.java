package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAllByStatusFalse(Pageable pageable);

    Blog findById(int id);

    void createBlog(Blog blog);

    void update(Blog blog);

    boolean delete(int id);


    Page<Blog> findAllBlogByCategoryID(Integer id, Pageable pageable);

    Page<Blog> findAllByTitle(Pageable pageable, String title);
}
