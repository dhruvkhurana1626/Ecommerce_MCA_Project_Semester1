package com.ecommerce.MCA.dto.request;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddressRequest {

    private String houseNo;

    private String city;

    private String state;

    private int pinCode;

}
