package com.ecommerce.MCA.dto.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressResponse {
    private String houseno;
    private String city;
    private String state;
    private int pincode;
    private CustomerResponse customer;
}
