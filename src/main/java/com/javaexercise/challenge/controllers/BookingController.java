package com.javaexercise.challenge.controllers;

import com.javaexercise.challenge.dtos.CreateBookingRequestDTO;
import com.javaexercise.challenge.entities.Booking;
import com.javaexercise.challenge.services.CreateBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class BookingController {

    @Autowired
    private CreateBooking createBooking;

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBook(@PathVariable int id) {
        return ResponseEntity.ok(null);
    }

    @PostMapping("/")
    public ResponseEntity<Booking> createBooking(@RequestBody CreateBookingRequestDTO createBookingRequestDTO){
        return ResponseEntity.ok(createBooking.apply(createBookingRequestDTO));
    }
}
