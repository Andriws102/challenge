package com.javaexercise.challenge.services;

import com.javaexercise.challenge.dtos.GetBookByAuthorRequestDTO;
import com.javaexercise.challenge.dtos.GetBooksResponseDTO;

import java.util.function.Function;

@FunctionalInterface
public interface GetBookByAuthor extends Function<GetBookByAuthorRequestDTO, GetBooksResponseDTO> {
}
