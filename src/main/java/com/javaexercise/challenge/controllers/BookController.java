package com.javaexercise.challenge.controllers;

import com.javaexercise.challenge.entities.Book;
import com.javaexercise.challenge.services.GetBookById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private GetBookById getBookById;

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        var book = getBookById.apply(id);
        return book.orElse(null);
    }
}
