package com.javaexercise.challenge.dtos;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateReviewRequestDTO {
    private Long bookId;
    private Long userId;
    private String comment;
    private int rate;

}
