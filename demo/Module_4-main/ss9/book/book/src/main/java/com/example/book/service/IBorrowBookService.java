package com.example.book.service;

import com.example.book.model.Book;
import com.example.book.model.BorrowBook;

import java.util.List;

public interface IBorrowBookService {
    Integer create(Book book);

    List<BorrowBook> findAll();

    List<BorrowBook> findBorrowByBook(Book book);

    BorrowBook getBookByCode(Integer code);

    void updateFlagDelete(BorrowBook borrowBook);

    void deleteById(int id);
}
