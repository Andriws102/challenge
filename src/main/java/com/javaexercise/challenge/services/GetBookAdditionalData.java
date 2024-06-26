package com.javaexercise.challenge.services;

import com.javaexercise.challenge.dtos.CopiesInfoDto;
import com.javaexercise.challenge.dtos.GetBookResponseDTO;

import java.util.function.Function;

@FunctionalInterface
public interface GetBookAdditionalData extends Function<CopiesInfoDto, GetBookResponseDTO> {
}
