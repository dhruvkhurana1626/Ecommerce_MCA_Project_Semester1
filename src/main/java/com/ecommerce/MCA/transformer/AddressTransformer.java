package com.ecommerce.MCA.transformer;
import com.ecommerce.MCA.dto.request.AddressRequest;
import com.ecommerce.MCA.dto.response.AddressResponse;
import com.ecommerce.MCA.model.Address;

public class AddressTransformer {

    public static Address addressRequestToAddress(AddressRequest addressRequest){
        return Address.builder()
                .houseno(addressRequest.getHouseno())
                .city(addressRequest.getCity())
                .state(addressRequest.getState())
                .pincode(addressRequest.getPincode())
                .build();
    }

    public static AddressResponse addressToAddressResponse(Address address){
        return AddressResponse.builder()
                .houseno(address.getHouseno())
                .city(address.getCity())
                .state(address.getState())
                .pincode(address.getPincode())
                .customer(CustomerTransformer.customerToCustomerResponse(address.getCustomer()))
                .build();
    }
}
