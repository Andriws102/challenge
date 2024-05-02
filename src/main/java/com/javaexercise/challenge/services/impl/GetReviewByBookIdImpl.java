package com.javaexercise.challenge.services.impl;

import com.javaexercise.challenge.entities.Review;
import com.javaexercise.challenge.repositories.ReviewRepository;
import com.javaexercise.challenge.services.GetReviewByBookId;
import io.micrometer.observation.annotation.Observed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class GetReviewByBookIdImpl implements GetReviewByBookId {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    @Observed(name = "GetReviewByBookIdImpl")
    public List<Review> apply(Long bookId) {
        return reviewRepository.findByBookId(bookId);
    }
}
