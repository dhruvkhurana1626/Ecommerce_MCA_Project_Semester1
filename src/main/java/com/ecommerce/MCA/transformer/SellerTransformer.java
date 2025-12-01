package com.ecommerce.MCA.transformer;

import com.ecommerce.MCA.dto.request.SellerRequest;
import com.ecommerce.MCA.dto.response.SellerResponse;
import com.ecommerce.MCA.model.Seller;

import java.util.ArrayList;

public class SellerTransformer {

    public static Seller sellerRequestToSeller(SellerRequest sellerRequest){
        return Seller.builder()
                .name(sellerRequest.getName())
                .aadharcard(sellerRequest.getAadharcard())
                .phonenumber(sellerRequest.getPhonenumber())
                .email(sellerRequest.getEmail())
                .productList(new ArrayList<>())
                .build();

    }

    public static SellerResponse sellerToSellerResponse(Seller seller){
        return SellerResponse.builder()
                .name(seller.getName())
                .email(seller.getEmail())
                .createdAt(seller.getCreatedAt())
                .build();
    }
}
