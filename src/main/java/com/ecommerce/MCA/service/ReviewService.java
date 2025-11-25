package com.ecommerce.MCA.service;
import com.ecommerce.MCA.exception.ReviewNotFound;
import com.ecommerce.MCA.model.Review;
import com.ecommerce.MCA.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    public Review getReviewById(int id){
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if(optionalReview.isEmpty()){
            throw new ReviewNotFound("Review not found");
        }
        return optionalReview.get();
    }
}
