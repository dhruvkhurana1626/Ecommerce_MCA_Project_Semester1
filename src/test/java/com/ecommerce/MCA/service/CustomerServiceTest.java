package com.ecommerce.MCA.service;

import com.ecommerce.MCA.dto.response.CustomerResponse;
import com.ecommerce.MCA.model.Customer;
import com.ecommerce.MCA.enums.Gender;
import com.ecommerce.MCA.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void whenCustomerExists_thenReturnSaveCustomer(){
        //arrange
        Customer customer = Customer.builder()
                .id(1)
                .name("test-user")
                .age(30)
                .email("test-mail@test.com")
                .phonenumber("0000000000")
                .gender(Gender.MALE)
                .build();

        Mockito.when(customerRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(customer));

        //act
        CustomerResponse customerResponse = customerService.getCustomer(1);

        //assert
        Assertions.assertNotNull(customerResponse);
        Assertions.assertEquals(customerResponse.getName(),"test-user");
        Assertions.assertEquals(customerResponse.getEmail(),"test-mail@test.com");
    }
}
