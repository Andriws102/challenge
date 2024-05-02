package com.javaexercise.challenge.services;

import com.javaexercise.challenge.entities.Review;

import java.util.function.Function;

@FunctionalInterface
public interface GetReviewById extends Function<Long, Review> {
}
