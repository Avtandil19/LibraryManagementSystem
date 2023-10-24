package com.example.LibraryManagement.patron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PatronController {
    private final PatronService patronService;

    @Autowired
    public PatronController(PatronService patronService) {
        this.patronService = patronService;
    }

    @PostMapping("/add-patron")
    public void addPatron(@ModelAttribute Patron patron) {
        patronService.addPatron(patron);
    }

    @GetMapping("/add-patron")
    public String showAddPatron() {
        return "add-patron";
    }

    @GetMapping("/edit-patron/{id}")
    public String showUpdatePatron(@PathVariable("id") Long id, Model model) {
        Patron patron = patronService.findPatronById(id);
        model.addAttribute("patron", patron);
        return "edit-patron";
    }

    @PostMapping("/edit-patron/{id}")
    public String updatePatron(@ModelAttribute Patron patron) {
        patronService.updatePatron(patron);
        return "edit-patron";
    }

    @GetMapping("/delete-patron/{id}")
    public String removePatron(@PathVariable Long id) {
        patronService.removePatron(id);
        return "redirect:/patrons";
    }

    @GetMapping("/patrons")
    public String getAllPatrons(Model model) {
        List<Patron> patrons = patronService.getAllPatrons();
        model.addAttribute("patrons", patrons);
        return "patrons-list";
    }
}
