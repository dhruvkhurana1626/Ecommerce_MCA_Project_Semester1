package com.ecommerce.MCA.repository;

import com.ecommerce.MCA.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
}
