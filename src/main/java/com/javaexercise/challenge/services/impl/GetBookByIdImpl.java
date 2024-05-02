package com.javaexercise.challenge.services.impl;

import com.javaexercise.challenge.dtos.GetBookByIdRequestDTO;
import com.javaexercise.challenge.dtos.GetBookResponseDTO;
import com.javaexercise.challenge.entities.Book;
import com.javaexercise.challenge.entities.Review;
import com.javaexercise.challenge.repositories.BookAuthorRepository;
import com.javaexercise.challenge.repositories.BookCopyRepository;
import com.javaexercise.challenge.repositories.BookRepository;
import com.javaexercise.challenge.repositories.ReviewRepository;
import com.javaexercise.challenge.services.GetBookAdditionalData;
import com.javaexercise.challenge.services.GetBookById;
import io.micrometer.observation.annotation.Observed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class GetBookByIdImpl implements GetBookById {

    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    private final GetBookAdditionalData getBookAdditionalData;

    @Override
    @Observed(name="GetBookByIdImpl")
    public GetBookResponseDTO apply(GetBookByIdRequestDTO data) {
        var result = bookRepository.findById(data.getId());
        GetBookResponseDTO response;
        if(result.isPresent()) {

            if (data.getAllData()) {
                response = getBookAdditionalData.apply(data.getId());
            }else{
                response = new GetBookResponseDTO();
            }

            response.setBook(result.get());
        }else{
            response = new GetBookResponseDTO();
        }
        return response;
    }
}
