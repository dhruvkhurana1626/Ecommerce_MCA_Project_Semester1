package com.ecommerce.MCA.repository;

import com.ecommerce.MCA.model.Customer;
import com.ecommerce.MCA.model.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void shouldSucceed_whenValidCustomerIsSaved() {
        // arrange
        Customer customer = Customer.builder()
                .name("test")
                .age(52)
                .gender(Gender.MALE)
                .email("bdisakldkn@gmail.com")
                .phonenumber("000000000")
                .build();

        //act
        Customer savedCustomer = customerRepository.save(customer);

        // assert
        Assertions.assertEquals("test", savedCustomer.getName());
        Assertions.assertNotEquals(0, savedCustomer.getId());
        Assertions.assertNotNull(savedCustomer.getCreatedAt());

    }
}
