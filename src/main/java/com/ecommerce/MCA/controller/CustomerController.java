package com.ecommerce.MCA.controller;

import com.ecommerce.MCA.exception.CustomerNotFound;
import com.ecommerce.MCA.model.Customer;
import com.ecommerce.MCA.service.CustomerService;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        return new ResponseEntity<>("Customer added", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getCustomerById(@RequestParam ("id") int id){
        try {
            return new ResponseEntity(customerService.getCustomerById(id),HttpStatus.FOUND);
        }
        catch(CustomerNotFound e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
