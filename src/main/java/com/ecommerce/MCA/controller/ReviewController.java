package com.ecommerce.MCA.controller;

import com.ecommerce.MCA.dto.request.ReviewRequest;
import com.ecommerce.MCA.dto.response.ReviewResponse;
import com.ecommerce.MCA.exception.ReviewNotFound;
import com.ecommerce.MCA.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping
    public ResponseEntity getReviewById(@RequestParam("id") int id){
        try{
            return new ResponseEntity(reviewService.getReviewById(id),HttpStatus.FOUND);
        }
        catch(ReviewNotFound e){
            return new ResponseEntity("No reveiw found",HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity addReview(@RequestParam("c-id") int customerId,
                                    @RequestParam("p-id") int productId,
                                    @RequestBody ReviewRequest reviewRequest){
        try{
            ReviewResponse reviewResponse = ReviewService.addReview(customerId,productId,reviewRequest);
            return new ResponseEntity(reviewResponse,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
