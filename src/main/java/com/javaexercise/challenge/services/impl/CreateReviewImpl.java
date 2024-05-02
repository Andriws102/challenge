package com.javaexercise.challenge.services.impl;

import com.javaexercise.challenge.dtos.CreateReviewRequestDTO;
import com.javaexercise.challenge.entities.Review;
import com.javaexercise.challenge.repositories.BookRepository;
import com.javaexercise.challenge.repositories.ReviewRepository;
import com.javaexercise.challenge.repositories.UserRepository;
import com.javaexercise.challenge.services.CreateReview;
import io.micrometer.observation.annotation.Observed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
@Slf4j
public class CreateReviewImpl implements CreateReview {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    @Observed(name = "CreateReviewImpl")
    public Review apply(CreateReviewRequestDTO createReviewRequestDTO) {

        var user = userRepository.findById(createReviewRequestDTO.getUserId()).orElse(null);
        var book = bookRepository.findById(createReviewRequestDTO.getBookId()).orElse(null);

        Review review = Review.builder()
                .user(user)
                .book(book)
                .comment(createReviewRequestDTO.getComment())
                .rate(createReviewRequestDTO.getRate())
                .commentedAt(new Date())
                .build();

        return reviewRepository.save(review);

    }
}
