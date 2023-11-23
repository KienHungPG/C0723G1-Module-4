package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
@CrossOrigin("*")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping()
    public ResponseEntity<List<Blog>> getList() {
        List<Blog> blogs = this.blogService.getList();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogs, HttpStatus.OK);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Blog> getBlogDetail(@PathVariable Integer id) {
        if (blogService.checkId(id)) {
            return new ResponseEntity<>(this.blogService.findById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<?> createBlog(@RequestBody Blog blog) {
        if (blog != null) {
            this.blogService.createBlog(blog);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateBlog(@PathVariable Integer id, @RequestBody Blog blog) {
        if (blogService.checkId(id)) {
            blogService.update(blog);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteBlog(@PathVariable Integer id) {
        if (blogService.checkId(id)) {
            this.blogService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/{title}")
    @CrossOrigin("*")
    public ResponseEntity<List<Blog>> searchBlogs(@PathVariable String title) {
        List<Blog> blogs = blogService.findAllByTitle(title);
        if (blogs.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(blogs, HttpStatus.OK);
        }
    }

    @GetMapping("/getMoreBlogs/{number}")
    public ResponseEntity<List<Blog>> getMoreBlogs(@PathVariable int number) {
        List<Blog> blogs = blogService.getMoreBlog(number);
        if (blogs.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(blogs, HttpStatus.OK);
        }
    }
}
