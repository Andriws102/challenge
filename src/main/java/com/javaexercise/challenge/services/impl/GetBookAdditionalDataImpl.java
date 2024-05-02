package com.javaexercise.challenge.services.impl;

import com.javaexercise.challenge.dtos.CopiesInfoDto;
import com.javaexercise.challenge.dtos.GetBookResponseDTO;
import com.javaexercise.challenge.repositories.BookAuthorRepository;
import com.javaexercise.challenge.repositories.BookCopyRepository;
import com.javaexercise.challenge.repositories.ReviewRepository;
import com.javaexercise.challenge.services.GetBookAdditionalData;
import io.micrometer.observation.annotation.Observed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class GetBookAdditionalDataImpl implements GetBookAdditionalData {

    @Autowired
    private final ReviewRepository reviewRepository;

    @Autowired
    private final BookAuthorRepository bookAuthorRepository;

    @Autowired
    private final BookCopyRepository bookCopyRepository;

    @Override
    @Observed(name="GetBookAdditionalDataImpl")
    public GetBookResponseDTO apply(CopiesInfoDto info) {

        GetBookResponseDTO getBookResponseDTO = new GetBookResponseDTO();
        getBookResponseDTO.setReviews(reviewRepository.findByBookId(info.getBookId()));
        getBookResponseDTO.setBookAuthors(bookAuthorRepository.findByBookId(info.getBookId()));

        if(info.getOnlyAvailable()){
            getBookResponseDTO.setCopies(bookCopyRepository.findByBookIdAndStatusId(info.getBookId(),1));
        }else{
            getBookResponseDTO.setCopies(bookCopyRepository.findByBookId(info.getBookId()));
        }

        return getBookResponseDTO;
    }
}
