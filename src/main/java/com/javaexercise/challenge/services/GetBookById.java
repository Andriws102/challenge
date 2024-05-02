package com.javaexercise.challenge.services;

import com.javaexercise.challenge.entities.Book;

import java.util.Optional;
import java.util.function.Function;

@FunctionalInterface
public interface GetBookById extends Function<Long, Optional<Book>> {
}
