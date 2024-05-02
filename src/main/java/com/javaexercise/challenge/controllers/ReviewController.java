package com.javaexercise.challenge.controllers;

import com.javaexercise.challenge.dtos.CreateReviewRequestDTO;
import com.javaexercise.challenge.entities.Review;
import com.javaexercise.challenge.services.CreateReview;
import com.javaexercise.challenge.services.GetReviewByBookId;
import com.javaexercise.challenge.services.GetReviewById;
import com.javaexercise.challenge.services.GetReviewByUserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private CreateReview createReview;

    @Autowired
    private GetReviewById getReviewById;

    @Autowired
    private GetReviewByBookId getReviewByBookId;

    @Autowired
    private GetReviewByUserId getReviewByUserId;

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
            return ResponseEntity.ok(getReviewById.apply(id));
    }

    @GetMapping("/getByUser/{id}")
    public ResponseEntity<List<Review>> getReviewByUsers(@PathVariable Long id) {
        return ResponseEntity.ok(getReviewByUserId.apply(id));
    }

    @GetMapping("/getByBook/{id}")
    public ResponseEntity<List<Review>> getReviewByBook(@PathVariable Long id) {
        return ResponseEntity.ok(getReviewByBookId.apply(id));
    }

    @PostMapping("/")
    public ResponseEntity<Review> addReviewToBook(@RequestBody CreateReviewRequestDTO createReviewRequestDTO){
        return ResponseEntity.ok(createReview.apply(createReviewRequestDTO));
    }


}
