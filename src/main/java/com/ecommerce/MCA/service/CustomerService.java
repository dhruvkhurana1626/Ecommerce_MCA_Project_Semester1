package com.ecommerce.MCA.service;
import com.ecommerce.MCA.exception.CustomerNotFound;
import com.ecommerce.MCA.model.Customer;
import com.ecommerce.MCA.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer){
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    public Customer getCustomerById(int id){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFound("Invalid id");
        }
        return optionalCustomer.get();
    }
}
