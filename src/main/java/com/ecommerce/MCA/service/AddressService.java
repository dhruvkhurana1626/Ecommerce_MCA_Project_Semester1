package com.ecommerce.MCA.service;
import com.ecommerce.MCA.dto.request.AddressRequest;
import com.ecommerce.MCA.dto.response.AddressResponse;
import com.ecommerce.MCA.exception.AddressNotFound;
import com.ecommerce.MCA.exception.CustomerNotFound;
import com.ecommerce.MCA.model.Address;
import com.ecommerce.MCA.model.Customer;
import com.ecommerce.MCA.repository.AddressRepository;
import com.ecommerce.MCA.repository.CustomerRepository;
import com.ecommerce.MCA.transformer.AddressTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class AddressService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AddressRepository addressRepository;

    public AddressResponse addAddress(int customerId, AddressRequest addressRequest) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if(customerOptional.isEmpty()){
            throw new CustomerNotFound("Customer Id Invalid");
        }
        Customer customer = customerOptional.get();
        //DTO to Entity
        Address address = AddressTransformer.addressRequestToAddress(addressRequest);
        //relationship
        address.setCustomer(customer);
        //Saved in Repo
        Address savedAddress = addressRepository.save(address);
        //return response
        return AddressTransformer.addressToAddressResponse(savedAddress);
    }


    public void deleteAddressByCustomerId(int customerId) {

        Optional<Customer> customerOptional = customerRepository.findById(customerId);

        if(customerOptional.isEmpty()){
            throw new CustomerNotFound("Customer id is invalid");
        }

        Customer customer = customerOptional.get();
        Address address = customer.getAddress();

        addressRepository.delete(address);
    }


    public AddressResponse updateAddress(int customerId, AddressRequest addressRequest) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFound("Customer id is invalid");
        }
        Customer customer = optionalCustomer.get();

        if(customer.getAddress()==null){
            throw new AddressNotFound("Address not found , pls save the address before trying to update it");
        }

        Address existingAddress = customer.getAddress();

        existingAddress.setHouseNo(addressRequest.getHouseNo());
        existingAddress.setCity(addressRequest.getCity());
        existingAddress.setState(addressRequest.getState());
        existingAddress.setPinCode(addressRequest.getPinCode());

        existingAddress.setCustomer(customer);
        customer.setAddress(existingAddress);

        Address updatedAddress = addressRepository.save(existingAddress);

        return AddressTransformer.addressToAddressResponse(updatedAddress);
    }
}
