package com.javaexercise.challenge.services;

import com.javaexercise.challenge.entities.Review;

import java.util.List;
import java.util.function.Function;

@FunctionalInterface
public interface GetReviewByBookId extends Function<Long, List<Review>> {
}
