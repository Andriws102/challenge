package com.javaexercise.challenge.services.impl;

import com.javaexercise.challenge.entities.Review;
import com.javaexercise.challenge.repositories.ReviewRepository;
import com.javaexercise.challenge.services.GetReviewByUserId;
import io.micrometer.observation.annotation.Observed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class GetReviewByUserIdImpl implements GetReviewByUserId {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    @Observed(name = "GetReviewByUserIdImpl")
    public List<Review> apply(Long userId) {
        return reviewRepository.findByUserId(userId);
    }
}
