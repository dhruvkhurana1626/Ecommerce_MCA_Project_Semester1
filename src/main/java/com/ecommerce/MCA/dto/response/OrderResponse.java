package com.ecommerce.MCA.dto.response;

import com.ecommerce.MCA.enums.Orderstatus;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderResponse {
    private String id;
    private int value;
    private Orderstatus orderstatus;
    private CustomerResponse customerResponse;
}
