package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAllByStatusFalse();

    List<Blog> getList();

    Blog findById(int id);

    void createBlog(Blog blog);

    void update(Blog blog);

    boolean delete(int id);


    List<Blog> findAllBlogByCategoryID(Integer id);

    List<Blog> findAllByTitle(String title);


     boolean checkId(Integer id);

     List<Blog> getMoreBlog(int number);

}
