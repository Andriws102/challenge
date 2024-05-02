package com.javaexercise.challenge.services;

import com.javaexercise.challenge.dtos.UpdateBookingStatusRequestDTO;
import com.javaexercise.challenge.entities.Booking;

import java.util.function.Function;

@FunctionalInterface
public interface UpdateStatusBooking extends Function<UpdateBookingStatusRequestDTO, Booking> {
}
