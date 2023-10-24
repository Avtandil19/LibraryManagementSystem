package com.example.LibraryManagement.librarian;

import com.example.LibraryManagement.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Long> {
    Librarian findByUsername(String username);
}
