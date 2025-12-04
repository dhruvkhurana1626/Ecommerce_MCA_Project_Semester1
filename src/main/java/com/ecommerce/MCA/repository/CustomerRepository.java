package com.ecommerce.MCA.repository;
import com.ecommerce.MCA.model.Customer;
import com.ecommerce.MCA.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    List<Customer> findByGender(Gender gender);

    List<Customer> findByAgeGreaterThanEqual(int age);
}
