package com.ecommerce.MCA.controller;

import com.ecommerce.MCA.dto.request.SellerRequest;
import com.ecommerce.MCA.dto.response.SellerResponse;
import com.ecommerce.MCA.model.Seller;
import com.ecommerce.MCA.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @PostMapping
    public ResponseEntity addSeller(@RequestBody SellerRequest sellerRequest){
        SellerResponse sellerResponse = sellerService.addSeller(sellerRequest);
        return new ResponseEntity(sellerResponse,HttpStatus.CREATED);
    }
}
