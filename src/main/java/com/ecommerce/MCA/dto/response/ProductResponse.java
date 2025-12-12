package com.ecommerce.MCA.dto.response;

import com.ecommerce.MCA.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductResponse {
    private String name;
    private int price;
    private Category category;
    private SellerResponse sellerResponse;
}

