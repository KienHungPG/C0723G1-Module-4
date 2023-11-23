package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.repository.IBookRepository;
import com.example.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;


    @GetMapping("")
    public String home(Model model) {
        List<Book> books = bookService.getBook();
        model.addAttribute("books", books);
        return "home";
    }

    @GetMapping("{id}")
    public String bookDetail(@PathVariable int id, Model model) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            model.addAttribute("msg", "Book Not Found");
            return "error";
        }
        if (book.getQuantity() == 0) {
            model.addAttribute("msg", "Ít's Over");
        }
        model.addAttribute("book", book);
        return "book_details";
    }

}
