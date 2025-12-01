package com.ecommerce.MCA.dto.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressRequest {
    private String houseno;
    private String city;
    private String state;
    private int pincode;
}
