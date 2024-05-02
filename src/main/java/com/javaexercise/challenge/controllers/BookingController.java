package com.javaexercise.challenge.controllers;

import com.javaexercise.challenge.dtos.CreateBookingRequestDTO;
import com.javaexercise.challenge.dtos.UpdateBookingStatusRequestDTO;
import com.javaexercise.challenge.entities.Booking;
import com.javaexercise.challenge.services.CreateBooking;
import com.javaexercise.challenge.services.GetBookingById;
import com.javaexercise.challenge.services.UpdateStatusBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class BookingController {

    @Autowired
    private CreateBooking createBooking;

    @Autowired
    private GetBookingById getBookingById;

    @Autowired
    private UpdateStatusBooking updateStatusBooking;

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBook(@PathVariable Long id) {
        return ResponseEntity.ok(getBookingById.apply(id));
    }

    @PatchMapping("/cancelReservation/{id}")
    public ResponseEntity<Booking> cancelReservation(@PathVariable Long id){
        return ResponseEntity.ok(updateStatusBooking.apply(
                UpdateBookingStatusRequestDTO.builder()
                        .bookingId(id)
                        .statusId(3)
                        .build()));
    }

    @PatchMapping("/finishReservation/{id}")
    public ResponseEntity<Booking> finishReservation(@PathVariable Long id){
        return ResponseEntity.ok(updateStatusBooking.apply(
                UpdateBookingStatusRequestDTO.builder()
                        .bookingId(id)
                        .statusId(2)
                        .build()));
    }

    @PatchMapping("/processReservation/{id}")
    public ResponseEntity<Booking> processReservation(@PathVariable Long id){
        return ResponseEntity.ok(updateStatusBooking.apply(
                UpdateBookingStatusRequestDTO.builder()
                        .bookingId(id)
                        .statusId(1)
                        .build()));
    }

    @PostMapping("/")
    public ResponseEntity<Booking> createBooking(@RequestBody CreateBookingRequestDTO createBookingRequestDTO){
        return ResponseEntity.ok(createBooking.apply(createBookingRequestDTO));
    }
}
