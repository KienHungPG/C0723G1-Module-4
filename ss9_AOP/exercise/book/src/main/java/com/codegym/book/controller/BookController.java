package com.codegym.book.controller;

import com.codegym.book.model.Book;


import com.codegym.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("")
    private String home(Model model){
        List<Book> books = bookService.findAllBook();
        model.addAttribute("books",books);
        return "/home";
    }
    @GetMapping("{id}")
    private String bookDetail(@PathVariable int id, Model model){
        Book book = bookService.findBookById(id);
        if (book == null){
            model.addAttribute("msg","Book not found");
            return "/error";
        }
        model.addAttribute("book",book);
        return "/book_details";
    }
}
