package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface IBlogService {
    Page<Blog> getBlog(Pageable pageable);

    void createBlog(Blog blog);

    Blog getBlogDetail(Integer id);

    void delete(Integer id);

    void update(Blog blog);

    Page<Blog> getAllBlogByCategoryID(Integer id, Pageable pageable);

    Page<Blog> search(String name, Pageable pageable);
}
