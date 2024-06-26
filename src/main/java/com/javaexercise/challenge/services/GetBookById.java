package com.javaexercise.challenge.services;

import com.javaexercise.challenge.dtos.GetBookByIdRequestDTO;
import com.javaexercise.challenge.dtos.GetBookResponseDTO;

import java.util.function.Function;

@FunctionalInterface
public interface GetBookById extends Function<GetBookByIdRequestDTO, GetBookResponseDTO> {
}
