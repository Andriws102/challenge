package com.javaexercise.challenge.services;

import com.javaexercise.challenge.entities.Booking;

import java.util.Optional;
import java.util.function.Function;

@FunctionalInterface
public interface GetBookingById extends Function<Long, Booking> {
}
