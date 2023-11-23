package com.example.book.repository;

import com.example.book.model.Book;
import com.example.book.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBorrowBookRepository extends JpaRepository<BorrowBook, Integer> {
    List<BorrowBook> findAllByFlagDeleteIsFalse();

    List<BorrowBook> findBorrowBookByBook(Book book);


    BorrowBook findByBorrowCode(int code);
}
