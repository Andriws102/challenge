package com.javaexercise.challenge.services;

import com.javaexercise.challenge.dtos.CreateBookingRequestDTO;
import com.javaexercise.challenge.entities.Booking;

import java.util.function.Function;

@FunctionalInterface
public interface CreateBooking extends Function<CreateBookingRequestDTO, Booking> {
}
