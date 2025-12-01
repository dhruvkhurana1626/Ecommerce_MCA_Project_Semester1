package com.ecommerce.MCA.repository;
import com.ecommerce.MCA.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
