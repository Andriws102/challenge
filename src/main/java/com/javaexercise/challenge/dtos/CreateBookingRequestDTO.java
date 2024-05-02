package com.javaexercise.challenge.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBookingRequestDTO {

    private Long userId;
    private Long bookCopyId;
    private Date bookingUntil;
    private Date bookingSince;
}
