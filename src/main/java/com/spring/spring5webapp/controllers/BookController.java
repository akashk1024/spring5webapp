package com.spring.spring5webapp.controllers;

import com.spring.spring5webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books",bookRepository.findAll());
        return "books";
    }
}
