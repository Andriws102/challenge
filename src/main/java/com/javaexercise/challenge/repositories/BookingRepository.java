package com.javaexercise.challenge.repositories;

import com.javaexercise.challenge.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
