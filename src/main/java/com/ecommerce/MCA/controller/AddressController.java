package com.ecommerce.MCA.controller;
import com.ecommerce.MCA.dto.request.AddressRequest;
import com.ecommerce.MCA.dto.response.AddressResponse;
import com.ecommerce.MCA.exception.CustomerNotFound;
import com.ecommerce.MCA.model.Address;
import com.ecommerce.MCA.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping
    public ResponseEntity addAddress(@RequestParam("customerId") int customerId,
                                     @RequestBody AddressRequest addressRequest) {
        try {
            AddressResponse response = addressService.addAddress(customerId, addressRequest);
            return new ResponseEntity(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity deleteAddressByCustomerId(@RequestParam("customerId") int customerId){
        try {
            addressService.deleteAddressByCustomerId(customerId);
            return new ResponseEntity("Address of Customer with Customer Id is "+customerId+" deleted succesfully",HttpStatus.GONE);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity updateAddress(@RequestParam ("customerId") int customerId,
                              @RequestBody AddressRequest addressRequest){
        try{
            return new ResponseEntity(addressService.updateAddress(customerId,addressRequest),HttpStatus.OK);
        }
        catch (CustomerNotFound e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}