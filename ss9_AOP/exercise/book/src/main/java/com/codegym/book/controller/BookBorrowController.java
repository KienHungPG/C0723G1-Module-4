package com.codegym.book.controller;

import com.codegym.book.model.Book;
import com.codegym.book.model.BookBorrow;
import com.codegym.book.service.IBookBorrowService;
import com.codegym.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/borrow")
public class BookBorrowController {
    @Autowired
    private IBookBorrowService bookBorrowService;
    @Autowired
    private IBookService bookService;

    @PostMapping("")
    public String borrowBook(@ModelAttribute Book book, Model model, RedirectAttributes redirectAttributes) {
        if (book == null) {
            model.addAttribute("msg", "Book not found");
        }
        bookService.borrowBook(book);
        bookBorrowService.create(book);
        redirectAttributes.addFlashAttribute("msg", "Borrow book successful. Your borrow code is: " + bookBorrowService.create(book));
        return "redirect:/book";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam("code") int code, RedirectAttributes redirectAttributes) {
        if (bookBorrowService.findBookByCode(code) == null) {
            redirectAttributes.addFlashAttribute("msg", "Not found borrow code");
            return "redirect:/book";
        } else {
            BookBorrow bookBorrow = bookBorrowService.findBookByCode(code);
            bookService.returnBook(bookBorrow.getBook());
            bookBorrowService.updateFlagDelete(bookBorrow);
            bookBorrowService.deleteById(bookBorrow.getId());
            redirectAttributes.addFlashAttribute("msg", "Return book successful");
        }
        return "redirect:/book";
    }
}
