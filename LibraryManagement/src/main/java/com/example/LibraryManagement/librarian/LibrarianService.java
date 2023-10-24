package com.example.LibraryManagement.librarian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrarianService {
    private final LibrarianRepository librarianRepository;

    @Autowired
    public LibrarianService(LibrarianRepository librarianRepository) {
        this.librarianRepository = librarianRepository;
    }

    public Librarian addLibrarian(Librarian librarian) {
        return librarianRepository.save(librarian);
    }

    public Librarian updateLibrarian(Librarian librarian) {
        return librarianRepository.save(librarian);
    }

    public void removeLibrarian(Long id) {
        librarianRepository.deleteById(id);
    }

    public Librarian findLibrarianById(Long id) {
        return librarianRepository.findById(id).orElse(null);
    }

    public Librarian findLibrarianByUsername(String username) {
        return librarianRepository.findByUsername(username);
    }

    public List<Librarian> getAllLibrarians() {
        return librarianRepository.findAll();
    }
}
