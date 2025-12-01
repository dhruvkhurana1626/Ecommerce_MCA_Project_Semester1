package com.ecommerce.MCA.controller;

import com.ecommerce.MCA.dto.request.CustomerRequest;
import com.ecommerce.MCA.dto.response.CustomerResponse;
import com.ecommerce.MCA.service.CustomerService;
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
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerrequest){
        CustomerResponse savedCustomer = customerService.addCustomer(customerrequest);
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
