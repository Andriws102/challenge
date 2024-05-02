package com.javaexercise.challenge.services.impl;

import com.javaexercise.challenge.dtos.CreateBookingRequestDTO;
import com.javaexercise.challenge.entities.BookCopy;
import com.javaexercise.challenge.entities.Booking;
import com.javaexercise.challenge.repositories.BookCopyRepository;
import com.javaexercise.challenge.repositories.BookingRepository;
import com.javaexercise.challenge.repositories.UserRepository;
import com.javaexercise.challenge.services.CreateBooking;
import io.micrometer.observation.annotation.Observed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
@Slf4j
public class CreateBookingImpl implements CreateBooking {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookCopyRepository bookCopyRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Observed(name = "CreateBookingImpl")
    public Booking apply(CreateBookingRequestDTO createBookingRequestDTO) {

        var bookCopy = bookCopyRepository.findById(createBookingRequestDTO.getBookCopyId()).orElse(null);

        var user = userRepository.findById(createBookingRequestDTO.getUserId()).orElse(null);

        Booking booking = Booking.builder()
                .bookCopy(bookCopy)
                .user(user)
                .bookingSince(createBookingRequestDTO.getBookingSince())
                .bookingUntil(createBookingRequestDTO.getBookingUntil())
                .status_id(0)
                .bookingAt(new Date())
                .build();

        return bookingRepository.save(booking);
    }
}
