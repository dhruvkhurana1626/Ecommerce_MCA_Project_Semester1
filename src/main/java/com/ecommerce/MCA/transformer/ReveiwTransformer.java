package com.ecommerce.MCA.transformer;

import com.ecommerce.MCA.dto.request.ReviewRequest;
import com.ecommerce.MCA.dto.response.ReviewResponse;
import com.ecommerce.MCA.model.Review;

public class ReveiwTransformer {
    public static Review reviewRequestToReview(ReviewRequest reviewRequest){
        return Review.builder()
                .comment(reviewRequest.getComment())
                .rating(reviewRequest.getRating())
                .build();
    }

    public static ReviewResponse reviewToReviewResponse(Review review){
        return ReviewResponse.builder()
                .comment(review.getComment())
                .rating(review.getRating())
                .productResponse(ProductTransformer.productToProductResponse(review.getProduct()))
                .customerResponse(CustomerTransformer.customerToCustomerResponse(review.getCustomer()))
                .build();
    }
}
