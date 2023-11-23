package com.codegym.blog.service.impl;

import com.codegym.blog.model.Blog;
import com.codegym.blog.repository.IBlogRepository;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> getBlog(Pageable pageable) {
        return blogRepository.findAllByFlagDeleteIsFalse(pageable);
    }

    @Override
    public void createBlog(Blog blog) {
        blog.setFlagDelete(false);
        blogRepository.save(blog);
    }

    @Override
    public Blog getBlogDetail(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        this.getBlogDetail(id).setFlagDelete(true);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Page<Blog> getAllBlogByCategoryID(Integer id, Pageable pageable) {
        return blogRepository.findBlogsByCategoryId(id, pageable);
    }

    @Override
    public Page<Blog> search(String name, Pageable pageable) {
        return blogRepository.searchBlog(name,pageable);
    }
}
