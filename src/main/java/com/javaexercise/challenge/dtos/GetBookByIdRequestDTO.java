package com.javaexercise.challenge.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetBookByIdRequestDTO {
    private Long id;
    private Boolean allData;
}
