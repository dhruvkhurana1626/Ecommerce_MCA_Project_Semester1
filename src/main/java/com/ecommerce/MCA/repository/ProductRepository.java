package com.ecommerce.MCA.repository;

import com.ecommerce.MCA.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
