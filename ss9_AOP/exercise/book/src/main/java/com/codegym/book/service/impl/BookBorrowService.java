package com.codegym.book.service.impl;

import com.codegym.book.model.Book;
import com.codegym.book.model.BookBorrow;
import com.codegym.book.repository.IBookBorrowRepository;
import com.codegym.book.service.IBookBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBorrowService implements IBookBorrowService {
    @Autowired
    private IBookBorrowRepository bookBorrowRepository;
    @Override
    public Integer create(Book book) {
        BookBorrow bookBorrow = new BookBorrow();
        bookBorrow.setFlagDelete(false);
        bookBorrow.setBook(book);
        int code = (int) Math.floor(((Math.random()*99999) + 10000));
        bookBorrow.setBorrowCode(code);
        bookBorrowRepository.save(bookBorrow);
        return code;
    }

    @Override
    public List<BookBorrow> findAll() {
        return bookBorrowRepository.findAllByFlagDeleteIsFalse();
    }

    @Override
    public List<BookBorrow> findBorrowBookByBook(Book book) {
        return bookBorrowRepository.findBorrowBookByBook(book);
    }

    @Override
    public BookBorrow findBookByCode(int code) {
        return bookBorrowRepository.findByBorrowCode(code);
    }

    @Override
    public void updateFlagDelete(BookBorrow bookBorrow) {
        bookBorrow.setFlagDelete(true);
        bookBorrowRepository.save(bookBorrow);
    }

    @Override
    public void deleteById(int id) {
        bookBorrowRepository.deleteById(id);
    }
}
