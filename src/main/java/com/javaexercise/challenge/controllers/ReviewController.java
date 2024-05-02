package com.javaexercise.challenge.controllers;

import com.javaexercise.challenge.entities.Review;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @GetMapping("/{id}")
    public ResponseEntity<Review> getBook(@PathVariable int id) {
        return ResponseEntity.ok(null);
    }
}
