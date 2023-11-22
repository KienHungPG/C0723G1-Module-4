package com.codegym.blog.service;

import com.codegym.blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getBlog();

    Blog findById(int id);

    void createBlog(Blog blog);
    //
    void update(Blog blog);
    //
    void delete(int id);
}
