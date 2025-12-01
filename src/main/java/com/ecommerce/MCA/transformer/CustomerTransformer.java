package com.ecommerce.MCA.transformer;
import com.ecommerce.MCA.dto.request.CustomerRequest;
import com.ecommerce.MCA.dto.response.CustomerResponse;
import com.ecommerce.MCA.model.Customer;

public class CustomerTransformer {

    public static Customer customerRequestToCustomer(CustomerRequest customerRequest){
        return Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .email(customerRequest.getEmail())
                .gender(customerRequest.getGender())
                .phonenumber(customerRequest.getPhonenumber())
                .build();
    }

    public static CustomerResponse customerToCustomerResponse(Customer customer){
        return CustomerResponse.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .createdAt(customer.getCreatedAt())
                .build();
    }
}
