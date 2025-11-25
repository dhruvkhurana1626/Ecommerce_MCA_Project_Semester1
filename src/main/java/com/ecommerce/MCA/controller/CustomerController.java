package com.ecommerce.MCA.controller;

import com.ecommerce.MCA.exception.CustomerNotFound;
import com.ecommerce.MCA.model.Customer;
import com.ecommerce.MCA.service.CustomerService;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.Null;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api/v1/customer")
@Slf4j
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody Customer customer){
        log.info("customer :" + customer);
        Customer savedCustomer = customerService.addCustomer(customer);
        return new ResponseEntity(savedCustomer,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getCustomer(@RequestParam int id){
        try{
            return new ResponseEntity(customerService.getCustomer(id),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
