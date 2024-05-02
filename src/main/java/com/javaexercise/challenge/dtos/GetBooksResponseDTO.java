package com.javaexercise.challenge.dtos;

import com.javaexercise.challenge.entities.Book;
import com.javaexercise.challenge.entities.BookAuthor;
import com.javaexercise.challenge.entities.BookCopy;
import com.javaexercise.challenge.entities.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetBooksResponseDTO {
    private List<GetBookResponseDTO> books;
}
