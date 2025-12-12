package com.ecommerce.MCA.service;
import com.ecommerce.MCA.dto.request.CustomerRequest;
import com.ecommerce.MCA.dto.response.CustomerResponse;
import com.ecommerce.MCA.exception.CustomerNotFound;
import com.ecommerce.MCA.model.Customer;
import com.ecommerce.MCA.enums.Gender;
import com.ecommerce.MCA.repository.CustomerRepository;
import com.ecommerce.MCA.transformer.CustomerTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest){
        //Step 1 - Request DTO to Entity
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);
        //Step 2 - Save
        Customer savedCustomer = customerRepository.save(customer);
        //Step 3 - Entity to DTO
        CustomerResponse customerResponse = CustomerTransformer.customerToCustomerResponse(savedCustomer);
        return customerResponse;
    }

    public CustomerResponse getCustomer(int id){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFound("Invalid id");
        }
        Customer customer = optionalCustomer.get();
        return CustomerTransformer.customerToCustomerResponse(customer);
    }


    public List<CustomerResponse> getCustomerByGender(Gender gender) {

        List<Customer> customersByGender = customerRepository.findByGender(gender);
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer: customersByGender) {
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }

    public List<CustomerResponse> getCustomerByAge(int age) {
        List<Customer> customerByAge = customerRepository.findByAgeGreaterThanEqual(age);
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer: customerByAge){
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }

    public void deleteCustomerById(int customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if(customerOptional.isEmpty()){
            throw new CustomerNotFound("Customer id not found");
        }
        customerRepository.delete(customerOptional.get());
    }
}
