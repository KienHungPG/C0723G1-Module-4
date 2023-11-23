package com.example.book.service.impl;

import com.example.book.model.Book;
import com.example.book.model.BorrowBook;
import com.example.book.repository.IBorrowBookRepository;
import com.example.book.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowBookService implements IBorrowBookService {
    @Autowired
    private IBorrowBookRepository borrowBookRepository;

    @Override
    public Integer create(Book book) {
        BorrowBook borrowBook = new BorrowBook();
        borrowBook.setFlagDelete(false);
        borrowBook.setBook(book);
        int code = (int) Math.floor(((Math.random()*99999) + 10000));
        borrowBook.setBorrowCode(code);
        borrowBookRepository.save(borrowBook);
        return code;
    }

    @Override
    public List<BorrowBook> findAll() {
        return borrowBookRepository.findAllByFlagDeleteIsFalse();
    }

    @Override
    public List<BorrowBook> findBorrowByBook(Book book) {
        return borrowBookRepository.findBorrowBookByBook(book);
    }

    @Override
    public BorrowBook getBookByCode(Integer code) {
        return borrowBookRepository.findByBorrowCode(code);
    }

    @Override
    public void updateFlagDelete(BorrowBook borrowBook) {
        borrowBook.setFlagDelete(true);
        borrowBookRepository.save(borrowBook);
    }
    @Override
    public void deleteById(int id) {
        borrowBookRepository.deleteById(id);
    }
}
