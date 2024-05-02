package com.javaexercise.challenge.services.impl;

import com.javaexercise.challenge.dtos.CopiesInfoDto;
import com.javaexercise.challenge.dtos.GetBookByTitleRequestDTO;
import com.javaexercise.challenge.dtos.GetBookResponseDTO;
import com.javaexercise.challenge.dtos.GetBooksResponseDTO;
import com.javaexercise.challenge.repositories.BookRepository;
import com.javaexercise.challenge.services.GetBookAdditionalData;
import com.javaexercise.challenge.services.GetBookByTitle;
import io.micrometer.observation.annotation.Observed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class GetBookByTitleImpl implements GetBookByTitle {

    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    private final GetBookAdditionalData getBookAdditionalData;

    @Override
    @Observed(name="GetBookByTitleImpl")
    public GetBooksResponseDTO apply(GetBookByTitleRequestDTO data) {

        var result = bookRepository.findByPartialTitle(data.getTitle());
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
