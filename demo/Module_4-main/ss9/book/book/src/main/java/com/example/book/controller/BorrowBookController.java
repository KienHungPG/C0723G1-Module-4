package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.model.BorrowBook;
import com.example.book.service.IBookService;
import com.example.book.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/borrow")
public class BorrowBookController {
    @Autowired
    private IBorrowBookService borrowBookService;
    @Autowired
    private IBookService bookService;

    @PostMapping("")
    public String borrow(@ModelAttribute Book book, Model model, RedirectAttributes redirectAttributes) {
        if (book == null) {
            model.addAttribute("msg", "Book Not Found");
        }
        bookService.borrowBook(book);
        borrowBookService.create(book);
        redirectAttributes.addFlashAttribute("msg", "Borrow Book Oke And Your Code:"
                + borrowBookService.create(book));
        return "redirect:/book";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam("code") int code, RedirectAttributes redirectAttributes) {
        if (borrowBookService.getBookByCode(code) == null) {
            redirectAttributes.addFlashAttribute("msg", "Not Found Code");
            return "redirect:/book";
        } else {
            BorrowBook borrowBook = borrowBookService.getBookByCode(code);
            bookService.returnBook(borrowBook.getBook());
            borrowBookService.updateFlagDelete(borrowBook);
            borrowBookService.deleteById(borrowBook.getId());
            redirectAttributes.addFlashAttribute("msg", "Return Book Oke");
        }
        return "redirect:/book";
    }

}
