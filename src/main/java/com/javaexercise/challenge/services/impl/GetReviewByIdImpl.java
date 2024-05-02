package com.javaexercise.challenge.services.impl;

import com.javaexercise.challenge.entities.Review;
import com.javaexercise.challenge.repositories.ReviewRepository;
import com.javaexercise.challenge.services.GetReviewById;
import io.micrometer.observation.annotation.Observed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class GetReviewByIdImpl implements GetReviewById {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    @Observed(name = "GetReviewByIdImpl")
    public Review apply(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }
}
