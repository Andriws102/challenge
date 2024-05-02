package com.javaexercise.challenge.services.impl;

import com.javaexercise.challenge.dtos.UpdateBookingStatusRequestDTO;
import com.javaexercise.challenge.entities.Booking;
import com.javaexercise.challenge.repositories.BookingRepository;
import com.javaexercise.challenge.services.UpdateStatusBooking;
import io.micrometer.observation.annotation.Observed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UpdateStatusBookingImpl implements UpdateStatusBooking {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    @Observed(name = "UpdateStatusBookingImpl")
    public Booking apply(UpdateBookingStatusRequestDTO updateBookingStatusRequestDTO) {

        var booking = bookingRepository.findById(updateBookingStatusRequestDTO.getBookingId());

        if(booking.isPresent()) {
            booking.get().setStatus_id(updateBookingStatusRequestDTO.getStatusId());

            return bookingRepository.save(booking.get());
        }else{
            log.info("Booking with id:{updateBookingStatusRequestDTO.getBookingId()} not found");
            return null;
        }
    }
}
