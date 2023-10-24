package com.example.LibraryManagement.librarian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/librarians")
public class LibrarianController {
    private final LibrarianService librarianService;

    @Autowired
    public LibrarianController(LibrarianService librarianService) {
        this.librarianService = librarianService;
    }

    @PostMapping
    public Librarian addLibrarian(@RequestBody Librarian librarian) {
        return librarianService.addLibrarian(librarian);
    }

    @PutMapping("/{id}")
    public Librarian updateLibrarian(@PathVariable Long id, @RequestBody Librarian librarian) {
        librarian.setId(id);
        return librarianService.updateLibrarian(librarian);
    }

    @DeleteMapping("/{id}")
    public void removeLibrarian(@PathVariable Long id) {
        librarianService.removeLibrarian(id);
    }

    @GetMapping("/{id}")
    public Librarian getLibrarian(@PathVariable Long id) {
        return librarianService.findLibrarianById(id);
    }

    @GetMapping
    public List<Librarian> getAllLibrarians() {
        return librarianService.getAllLibrarians();
    }
}
