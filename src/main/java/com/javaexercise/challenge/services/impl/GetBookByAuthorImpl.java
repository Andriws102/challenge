package com.javaexercise.challenge.services.impl;

import com.javaexercise.challenge.dtos.CopiesInfoDto;
import com.javaexercise.challenge.dtos.GetBookByAuthorRequestDTO;
import com.javaexercise.challenge.dtos.GetBookResponseDTO;
import com.javaexercise.challenge.dtos.GetBooksResponseDTO;
import com.javaexercise.challenge.repositories.AuthorRepository;
import com.javaexercise.challenge.repositories.BookAuthorRepository;
import com.javaexercise.challenge.repositories.BookRepository;
import com.javaexercise.challenge.services.GetBookAdditionalData;
import com.javaexercise.challenge.services.GetBookByAuthor;
import io.micrometer.observation.annotation.Observed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class GetBookByAuthorImpl implements GetBookByAuthor {

    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    private final AuthorRepository authorRepository;

    @Autowired
    private final BookAuthorRepository bookAuthorRepository;

    @Autowired
    private final GetBookAdditionalData getBookAdditionalData;

    @Override
    @Observed(name = "GetBookByAuthorImpl")
    public GetBooksResponseDTO apply(GetBookByAuthorRequestDTO data) {

        var authors = authorRepository.findByName(data.getAuthorName());

        var booksAuthor = bookAuthorRepository.findByAuthor(authors);

        var result = bookRepository.findAllById(booksAuthor.stream().map(bookAuthor -> bookAuthor.getBook().getId()).toList());

        GetBooksResponseDTO response = new GetBooksResponseDTO();
        response.setBooks(result.stream().map(book -> {
            GetBookResponseDTO getBookResponseDTO;
            if(data.getAllData()){
                getBookResponseDTO = getBookAdditionalData.apply(CopiesInfoDto.builder().bookId(book.getId()).onlyAvailable(data.getOnlyAvailable()).build());
            }else{
                getBookResponseDTO = new GetBookResponseDTO();
            }
            getBookResponseDTO.setBook(book);
            return getBookResponseDTO;
        }).toList());

        return response;
    }
}
