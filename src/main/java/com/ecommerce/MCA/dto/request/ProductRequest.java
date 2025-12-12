package com.ecommerce.MCA.dto.request;

import com.ecommerce.MCA.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRequest {
    private String name;
    private int price;
    private Category category;
}
