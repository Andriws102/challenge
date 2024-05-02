package com.javaexercise.challenge.repositories;

import com.javaexercise.challenge.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
