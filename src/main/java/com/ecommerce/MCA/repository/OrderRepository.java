package com.ecommerce.MCA.repository;

import com.ecommerce.MCA.model.Orderentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orderentity,Integer> {
}
