package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.IBlogService;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/blog")
    public ResponseEntity<Page<Blog>> getPage(@RequestParam(defaultValue = "") String searchName,
                                              @RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "0") int idCate) {
        Pageable pageable = PageRequest.of(page, 3, Sort.by("date").descending());
        Page<Blog> blogPage;
        if (idCate == 0) {
            blogPage = blogService.displayAllBlog(searchName, pageable);
        } else {
            blogPage = blogService.searchByCategoryAndName(searchName, pageable, idCate);
        }
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }
    @GetMapping("/blog/detail/{id}")
    public ResponseEntity<Blog> getDetail(@PathVariable int id) {
        Blog blog = blogService.getBlog(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getCategory(){
        List<Category> categories = categoryService.getAllCategory();
        if (categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }
}
