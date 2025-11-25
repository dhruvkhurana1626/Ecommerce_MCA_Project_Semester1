package com.ecommerce.MCA.controller;
import com.ecommerce.MCA.exception.ReviewNotFound;
import com.ecommerce.MCA.service.ReviewService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    public ResponseEntity getReviewById(@RequestParam("id") int id){
        try{
            return new ResponseEntity(reviewService.getReviewById(id),HttpStatus.FOUND);
        }
        catch(ReviewNotFound e){
            return new ResponseEntity("No reveiw found",HttpStatus.NOT_FOUND);
        }
    }
}
