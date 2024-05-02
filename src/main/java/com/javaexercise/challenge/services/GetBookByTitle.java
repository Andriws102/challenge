package com.javaexercise.challenge.services;

import com.javaexercise.challenge.dtos.GetBookByTitleRequestDTO;
import com.javaexercise.challenge.dtos.GetBooksResponseDTO;

import java.util.function.Function;

@FunctionalInterface
public interface GetBookByTitle extends Function<GetBookByTitleRequestDTO, GetBooksResponseDTO> {
}
