package com.codegym.book.service;

import com.codegym.book.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAllBook();
    void borrowBook(Book book);
    void returnBook(Book book);
    Book findBookById(int id);
}
