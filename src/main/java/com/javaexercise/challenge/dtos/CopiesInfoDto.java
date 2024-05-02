package com.javaexercise.challenge.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CopiesInfoDto {
    private Long bookId;
    private Boolean onlyAvailable;
}
