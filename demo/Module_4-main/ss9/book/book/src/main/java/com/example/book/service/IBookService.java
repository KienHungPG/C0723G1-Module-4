package com.example.book.service;

import com.example.book.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getBook();

    void borrowBook(Book book);

     void  returnBook(Book book);

    Book getBookById(int id);

}
