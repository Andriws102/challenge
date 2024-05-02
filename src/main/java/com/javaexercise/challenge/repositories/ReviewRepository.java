package com.javaexercise.challenge.repositories;

import com.javaexercise.challenge.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    List<Review> findByBookId(Long bookId);

    List<Review> findByUserId(Long userId);
}
