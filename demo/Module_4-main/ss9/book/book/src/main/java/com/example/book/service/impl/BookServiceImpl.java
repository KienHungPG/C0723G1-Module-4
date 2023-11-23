package com.example.book.service.impl;

import com.example.book.model.Book;
import com.example.book.repository.IBookRepository;
import com.example.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> getBook() {
        return bookRepository.findAll();
    }

    @Override
    public void borrowBook(Book book) {
        if (book != null && book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() - 1);
            bookRepository.save(book);
        }
    }

    @Override
    public void returnBook(Book book) {
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }
}
