package com.javaexercise.challenge.services;

import com.javaexercise.challenge.dtos.UpdateBookStatusRequestDTO;
import com.javaexercise.challenge.entities.BookCopy;

import java.util.function.Function;

@FunctionalInterface
public interface UpdateStatusBookCopy extends Function<UpdateBookStatusRequestDTO, BookCopy> {
}
