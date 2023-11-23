package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogCatogoryService;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private IBlogCatogoryService catogoryService;
    @Autowired
    private IBlogService blogService;

    @GetMapping()
    public ResponseEntity<List<Category>> getList() {
        List<Category> categories = this.catogoryService.getCategory();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<List<Blog>> getListBlog(@PathVariable Integer id) {
        if (catogoryService.checkId(id)) {
            return new ResponseEntity<>(blogService.findAllBlogByCategoryID(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Integer id, @RequestBody Category category) {
        if (catogoryService.checkId(id)) {
            catogoryService.update(category);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<?> createCategory(@RequestBody Category category) {
        if (category != null) {
            catogoryService.save(category);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
        if (catogoryService.checkId(id)) {
            this.catogoryService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
