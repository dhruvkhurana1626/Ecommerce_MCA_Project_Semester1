package com.ecommerce.MCA.controller;


import com.ecommerce.MCA.dto.request.CustomerRequest;
import com.ecommerce.MCA.dto.response.CustomerResponse;
import com.ecommerce.MCA.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    @Test
    void addCustomer(){
        //Arrange
        CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setName("dhruv");
        customerRequest.setEmail("testmail@gmail.com");

        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setName("dhruv");
        customerResponse.setEmail("testmail@gmail.com");

        //Mock Service Behaviour
        when(customerService.addCustomer(customerRequest)).thenReturn(customerResponse);

        //Act
        ResponseEntity<CustomerResponse> result = customerController.addCustomer(customerRequest);

        //Assert
        Assertions.assertEquals(201,result.getStatusCodeValue());
        Assertions.assertEquals(customerResponse,result.getBody());
    }


}
