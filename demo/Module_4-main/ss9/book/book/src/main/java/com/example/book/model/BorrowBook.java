package com.example.book.model;

import javax.persistence.*;

@Entity
@Table(name = "borrow_books")
public class BorrowBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int borrowCode;

    private boolean flagDelete;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    public BorrowBook(int id, int borrowCode, boolean flagDelete, Book book) {
        this.id = id;
        this.borrowCode = borrowCode;
        this.flagDelete = flagDelete;
        this.book = book;
    }

    public BorrowBook() {
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(int borrowCode) {
        this.borrowCode = borrowCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
