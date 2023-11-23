package com.example.blog.service.impl;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public Page<Blog> findAllByStatusFalse(Pageable pageable) {
        return this.blogRepository.findAllByStatusFalse(pageable);
    }

    @Override
    public Blog findById(int id) {
        return this.blogRepository.findById(id).orElse(null);
    }

    @Override
    public void createBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public boolean delete(int id) {
//        Optional<Blog> blog = blogRepository.findById(id);
        Blog blog = blogRepository.findById(id).orElse(null);
        if (blog != null) {
            blog.setStatus(true);
            blogRepository.save(blog);
            return true;
        }
        return false;
    }

    @Override
    public Page<Blog> findAllBlogByCategoryID(Integer id, Pageable pageable) {
        return blogRepository.findBlogsByCategoryIdAndStatusIsFalse(id, pageable);
    }

    @Override
    public Page<Blog> findAllByTitle(Pageable pageable, String title) {
        return blogRepository.findAllByTitle(pageable, title);
    }
}
