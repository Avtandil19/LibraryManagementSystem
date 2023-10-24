package com.example.LibraryManagement.patron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PatronService {
    private final PatronRepository patronRepository;

    @Autowired
    public PatronService(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }

    public void addPatron(Patron patron) {
        patronRepository.save(patron);
    }

    public void updatePatron(Patron patron) {
        patronRepository.save(patron);
    }

    public void removePatron(Long id) {
        patronRepository.deleteById(id);
    }

    public Patron findPatronById(Long id) {
        return patronRepository.findById(id).orElse(null);
    }

    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }
}
