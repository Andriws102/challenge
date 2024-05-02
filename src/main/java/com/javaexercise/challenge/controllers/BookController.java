package com.javaexercise.challenge.controllers;

import com.javaexercise.challenge.dtos.*;
import com.javaexercise.challenge.services.GetBookByAuthor;
import com.javaexercise.challenge.services.GetBookById;
import com.javaexercise.challenge.services.GetBookByTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private GetBookById getBookById;

    @Autowired
    private GetBookByTitle getBookByTitle;

    @Autowired
    private GetBookByAuthor getBookByAuthor;

    @GetMapping("/{id}")
    public ResponseEntity<GetBookResponseDTO> getBookById(@PathVariable Long id,
                                                          @RequestParam Optional<Boolean> alldata,
                                                          @RequestParam Optional<Boolean> onlyavailable) {
        return ResponseEntity.ok(getBookById.apply(
                GetBookByIdRequestDTO.builder()
                        .id(id)
                        .allData(alldata.orElse(false))
                        .onlyAvailable(onlyavailable.orElse(false))
                        .build()));
    }

    @GetMapping("/getByTitle")
    public ResponseEntity<GetBooksResponseDTO> getBookByTitle(@RequestParam String title,
                                              @RequestParam Optional<Boolean> alldata,
                                              @RequestParam Optional<Boolean> onlyavailable) {
        return ResponseEntity.ok(getBookByTitle.apply(
                GetBookByTitleRequestDTO.builder()
                        .title(title)
                        .allData(alldata.orElse(false))
                        .onlyAvailable(onlyavailable.orElse(false))
                        .build()));
    }

        @GetMapping("/getByAuthor")
    public ResponseEntity<GetBooksResponseDTO> getBookByAuthor(@RequestParam String authorname,
                                               @RequestParam Optional<Boolean> alldata,
                                               @RequestParam Optional<Boolean> onlyavailable) {
        return ResponseEntity.ok(getBookByAuthor.apply(
                GetBookByAuthorRequestDTO.builder()
                        .authorName(authorname)
                        .allData(alldata.orElse(false))
                        .onlyAvailable(onlyavailable.orElse(false))
                        .build()));
    }
}
