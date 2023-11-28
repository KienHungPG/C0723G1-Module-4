package com.codegym.book.service;

import com.codegym.book.model.Book;
import com.codegym.book.model.BookBorrow;

import java.util.List;

public interface IBookBorrowService {
    Integer create(Book book);
    List<BookBorrow> findAll();
    List<BookBorrow> findBorrowBookByBook(Book book);
    BookBorrow findBookByCode(int code);
    void updateFlagDelete(BookBorrow bookBorrow);
    void deleteById(int id);
}
