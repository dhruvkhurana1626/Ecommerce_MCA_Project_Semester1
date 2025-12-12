package com.ecommerce.MCA.controller;

import com.ecommerce.MCA.dto.response.OrderResponse;
import com.ecommerce.MCA.repository.CustomerRepository;
import com.ecommerce.MCA.repository.ProductRepository;
import com.ecommerce.MCA.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity addOrder(@RequestParam("cus_id") int customerId,
                                   @RequestParam("prod_id") int productId){
        try{
            OrderResponse response = orderService.addOrder(customerId,productId);
            return new ResponseEntity(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
