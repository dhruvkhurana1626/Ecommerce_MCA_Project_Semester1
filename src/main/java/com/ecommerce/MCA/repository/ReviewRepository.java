package com.ecommerce.MCA.repository;

import com.ecommerce.MCA.dto.response.ReviewResponse;
import com.ecommerce.MCA.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
    List<Review> findByCommentContainingIgnoreCase(String word);
}
