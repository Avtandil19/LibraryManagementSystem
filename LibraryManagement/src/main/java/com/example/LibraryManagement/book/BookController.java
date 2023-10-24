package com.example.LibraryManagement.book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/add-book")
    public String showAddBook() {
        return "add-book";
    }

    @PostMapping("/add-book")
    public void addBook(@ModelAttribute Book book) {
        bookService.addBook(book);
    }

    @GetMapping("/edit-book/{id}")
    public String showUpdateBook(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        return "edit-book";
    }

    @PostMapping("/edit-book/{id}")
    public String updateBook(@ModelAttribute Book book) {
        bookService.updateBook(book);
        return "edit-book";
    }

    @GetMapping("/delete-book/{id}")
    public String removeBook(@PathVariable Long id) {
        bookService.removeBook(id);
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books-list";
    }
}
