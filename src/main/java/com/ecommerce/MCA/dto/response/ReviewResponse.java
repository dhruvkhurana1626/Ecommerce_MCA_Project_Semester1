package com.ecommerce.MCA.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class ReviewResponse {
    private String comment;
    private int rating;
    ProductResponse productResponse;
    CustomerResponse customerResponse;
}
