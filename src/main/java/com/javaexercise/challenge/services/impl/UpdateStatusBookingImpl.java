package com.javaexercise.challenge.services.impl;

import com.javaexercise.challenge.dtos.UpdateBookStatusRequestDTO;
import com.javaexercise.challenge.dtos.UpdateBookingStatusRequestDTO;
import com.javaexercise.challenge.entities.Booking;
import com.javaexercise.challenge.repositories.BookingRepository;
import com.javaexercise.challenge.services.UpdateStatusBookCopy;
import com.javaexercise.challenge.services.UpdateStatusBooking;
import io.micrometer.observation.annotation.Observed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
@Slf4j
public class UpdateStatusBookingImpl implements UpdateStatusBooking {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UpdateStatusBookCopy updateStatusBookCopy;

    @Override
    @Observed(name = "UpdateStatusBookingImpl")
    public Booking apply(UpdateBookingStatusRequestDTO updateBookingStatusRequestDTO) {

        var booking = bookingRepository.findById(updateBookingStatusRequestDTO.getBookingId());

        if(booking.isPresent()) {
            booking.get().setStatus_id(updateBookingStatusRequestDTO.getStatusId());

            switch (updateBookingStatusRequestDTO.getStatusId()){
                case 1: // Process Booking, Change book copy to lent
                    updateStatusBookCopy.apply(UpdateBookStatusRequestDTO.builder()
                            .bookCopyId(booking.get().getBookCopy().getId())
                            .statusId(2)
                            .build());
                    break;
                case 2: // Finish Booking, Change book copy to available
                    booking.get().setReturnedAt(new Date());
                    updateStatusBookCopy.apply(UpdateBookStatusRequestDTO.builder()
                            .bookCopyId(booking.get().getBookCopy().getId())
                            .statusId(1)
                            .build());
                    break;
                case 3: // Cancel Booking, Change book copy to available
                    updateStatusBookCopy.apply(UpdateBookStatusRequestDTO.builder()
                            .bookCopyId(booking.get().getBookCopy().getId())
                            .statusId(1)
                            .build());
                    break;
            }

            return bookingRepository.save(booking.get());
        }else{
            log.info("Booking with id:{updateBookingStatusRequestDTO.getBookingId()} not found");
            return null;
        }
    }
}
