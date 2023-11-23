package com.example.blog.service.impl;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public List<Blog> findAllByStatusFalse() {
        return this.blogRepository.findAllByStatusFalse();
    }

    @Override
    public List<Blog> getList() {
        return this.blogRepository.findAllByStatusIsFalse();
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
    public List<Blog> findAllBlogByCategoryID(Integer id) {
        return blogRepository.findBlogsByCategoryIdAndStatusIsFalse(id);
    }

    @Override
    public List<Blog> findAllByTitle(String title) {
        return blogRepository.findBlogByTitleContainingAndStatusIsFalse(title);
    }


    @Override
    public boolean checkId(Integer id) {
        return blogRepository.existsBlogById(id);
    }

    @Override
    public List<Blog> getMoreBlog(int number) {
        return blogRepository.getMoreBlogs(number);
    }

}
