package com.ecommerce.MCA.transformer;
import com.ecommerce.MCA.dto.request.AddressRequest;
import com.ecommerce.MCA.dto.response.AddressResponse;
import com.ecommerce.MCA.model.Address;

public class AddressTransformer {

    public static Address addressRequestToAddress(AddressRequest addressRequest){
        return Address.builder()
                .houseNo(addressRequest.getHouseNo())
                .city(addressRequest.getCity())
                .state(addressRequest.getState())
                .pinCode(addressRequest.getPinCode())
                .build();
    }

    public static AddressResponse addressToAddressResponse(Address address){
        return AddressResponse.builder()
                .houseNo(address.getHouseNo())
                .city(address.getCity())
                .state(address.getState())
                .pinCode(address.getPinCode())
                .customer(CustomerTransformer.customerToCustomerResponse(address.getCustomer()))
                .build();
    }
}
