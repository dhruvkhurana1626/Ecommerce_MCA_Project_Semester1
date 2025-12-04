package com.ecommerce.MCA.controller;
import com.ecommerce.MCA.dto.request.ProductRequest;
import com.ecommerce.MCA.dto.response.ProductResponse;
import com.ecommerce.MCA.model.Product;
import com.ecommerce.MCA.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/product")

public class ProductController {

    @Autowired
    ProductService productService;

    //add products
    @PostMapping
    public ResponseEntity addProduct(@RequestParam("sellerId") int sellerId,
                                     @RequestBody ProductRequest productRequest){
        try{
            ProductResponse productResponse = productService.addProduct(sellerId,productRequest);
            return new ResponseEntity(productResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
