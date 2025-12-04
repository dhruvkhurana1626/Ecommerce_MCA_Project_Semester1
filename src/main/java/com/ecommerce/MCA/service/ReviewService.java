package com.ecommerce.MCA.service;
import com.ecommerce.MCA.dto.request.ReviewRequest;
import com.ecommerce.MCA.dto.response.ReviewResponse;
import com.ecommerce.MCA.exception.CustomerNotFound;
import com.ecommerce.MCA.exception.ProductNotFound;
import com.ecommerce.MCA.exception.ReviewNotFound;
import com.ecommerce.MCA.model.Customer;
import com.ecommerce.MCA.model.Product;
import com.ecommerce.MCA.model.Review;
import com.ecommerce.MCA.repository.CustomerRepository;
import com.ecommerce.MCA.repository.ProductRepository;
import com.ecommerce.MCA.repository.ReviewRepository;
import com.ecommerce.MCA.transformer.ReveiwTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ReviewRepository reviewRepository;

    public ReviewResponse addReview(int customerId, int productId, ReviewRequest reviewRequest) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFound("Customer id is invalid");
        }

        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFound("Product id is inavlid");
        }

        Customer customer = optionalCustomer.get();
        Product product = optionalProduct.get();

        Review review = ReveiwTransformer.reviewRequestToReview(reviewRequest);

        //making relaitonship
        review.setCustomer(customer);
        review.setProduct(product);

        //save review
        Review savedReview = reviewRepository.save(review);

        //return
        return ReveiwTransformer.reviewToReviewResponse(savedReview);
    }

    public Review getReviewById(int id){
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if(optionalReview.isEmpty()){
            throw new ReviewNotFound("Review not found");
        }
        return optionalReview.get();
    }
}
