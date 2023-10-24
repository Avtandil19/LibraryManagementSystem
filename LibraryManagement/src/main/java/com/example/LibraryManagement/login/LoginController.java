package com.example.LibraryManagement.login;

import com.example.LibraryManagement.librarian.Librarian;
import com.example.LibraryManagement.librarian.LibrarianService;
import com.example.LibraryManagement.patron.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final LibrarianService librarianService;

    @Autowired
    public LoginController(LibrarianService librarianService) {
        this.librarianService = librarianService;
    }

    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        Librarian librarian = librarianService.findLibrarianByUsername(username);
        System.out.println(librarian);
        if (librarian == null) return "/login-failed";
        if (librarian.getPassword().equals(password)) {
            return "redirect:/books";
        }
        return "/login-failed";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public void registerPage(@RequestParam("username") String username, @RequestParam("password") String password) {
        Librarian librarian = new Librarian(username, password);
        librarianService.addLibrarian(librarian);
    }

    @GetMapping("/logout")
    public String logout() {
        return "/login";
    }
}
