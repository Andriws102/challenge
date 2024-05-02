package com.javaexercise.challenge.services;

import com.javaexercise.challenge.dtos.CreateReviewRequestDTO;
import com.javaexercise.challenge.entities.Review;

import java.util.function.Function;

@FunctionalInterface
public interface CreateReview extends Function<CreateReviewRequestDTO, Review> {

}
