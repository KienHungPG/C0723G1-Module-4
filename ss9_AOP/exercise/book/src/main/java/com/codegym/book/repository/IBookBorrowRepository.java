package com.codegym.book.repository;

import com.codegym.book.model.Book;
import com.codegym.book.model.BookBorrow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookBorrowRepository extends JpaRepository<BookBorrow,Integer> {
    List<BookBorrow> findAllByFlagDeleteIsFalse();

    List<BookBorrow> findBorrowBookByBook(Book book);


    BookBorrow findByBorrowCode(int code);
}
