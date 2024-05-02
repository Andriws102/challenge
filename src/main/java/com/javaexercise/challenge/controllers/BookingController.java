package com.javaexercise.challenge.controllers;

import com.javaexercise.challenge.entities.Booking;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
public class BookingController {

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBook(@PathVariable int id) {
        return ResponseEntity.ok(null);
    }
}
