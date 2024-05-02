package com.javaexercise.challenge.services.impl;

import com.javaexercise.challenge.entities.Booking;
import com.javaexercise.challenge.repositories.BookingRepository;
import com.javaexercise.challenge.services.GetBookingById;
import io.micrometer.observation.annotation.Observed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class GetBookingByIdImpl implements GetBookingById {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    @Observed(name = "GetBookingByIdImpl")
    public Booking apply(Long bookingId) {
        return bookingRepository.findById(bookingId).orElse(null);
    }
}
