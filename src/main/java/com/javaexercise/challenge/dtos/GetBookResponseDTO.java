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
import java.util.Optional;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetBookResponseDTO {
    private Book book;
    private List<Review> reviews;
    private List<BookAuthor> bookAuthors;
    private List<BookCopy> copies;
}
