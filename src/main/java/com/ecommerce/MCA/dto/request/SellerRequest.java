package com.ecommerce.MCA.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class SellerRequest {
    private String name;
    private String aadharcard;
    private String phonenumber;
    private String email;
}
