package com.example.book.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private int quantity;

    @OneToMany
    private List<BorrowBook> borrowBooks;

    public Book() {
    }

    public Book(int id, String name, int quantity, List<BorrowBook> borrowBooks) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.borrowBooks = borrowBooks;
    }

    public Book(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public List<BorrowBook> getBorrowBooks() {
        return borrowBooks;
    }

    public void setBorrowBooks(List<BorrowBook> borrowBooks) {
        this.borrowBooks = borrowBooks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
