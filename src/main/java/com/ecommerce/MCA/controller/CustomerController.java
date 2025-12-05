package com.ecommerce.MCA.controller;

import com.ecommerce.MCA.dto.request.CustomerRequest;
import com.ecommerce.MCA.dto.response.CustomerResponse;
import com.ecommerce.MCA.exception.CustomerNotFound;
import com.ecommerce.MCA.model.Gender;
import com.ecommerce.MCA.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //filter based on gender
    //input - gender
    //output - list<CustomerResponse>
     @GetMapping("/gender/{gender}")
    public ResponseEntity getCustomerByGender(@PathVariable Gender gender){
        List<CustomerResponse> responseList = customerService.getCustomerByGender(gender);
        return new ResponseEntity(responseList,HttpStatus.OK);
     }

     //input - age
     //List<customerResponse> where age >= input age
     @GetMapping("/age")
    public ResponseEntity getCustomerByAge(@RequestParam int age){
        List<CustomerResponse> responseList = customerService.getCustomerByAge(age);
        return new ResponseEntity(responseList,HttpStatus.OK);
     }

     @DeleteMapping
    public ResponseEntity deleteCustomerById(@RequestParam int customerId){
        try {
            customerService.deleteCustomerById(customerId);
            return new ResponseEntity("Customer with :" + customerId + "is deleted",HttpStatus.GONE);
        } catch (CustomerNotFound e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
     }

}
