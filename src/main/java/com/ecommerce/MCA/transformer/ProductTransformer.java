package com.ecommerce.MCA.transformer;

import com.ecommerce.MCA.dto.request.ProductRequest;
import com.ecommerce.MCA.dto.response.ProductResponse;
import com.ecommerce.MCA.model.Product;

import java.util.ArrayList;

public class ProductTransformer {

    public static Product productRequestToProduct(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .category(productRequest.getCategory())
                .review(new ArrayList<>())
                .orders(new ArrayList<>())
                .build();
    }

    public static ProductResponse productToProductResponse(Product product){
        return ProductResponse.builder()
                .name(product.getName())
                .price(product.getPrice())
                .category(product.getCategory())
                .sellerResponse(SellerTransformer.sellerToSellerResponse(product.getSeller()))
                .build();
    }
}
