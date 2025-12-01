package com.ecommerce.MCA.service;
import com.ecommerce.MCA.dto.request.SellerRequest;
import com.ecommerce.MCA.dto.response.SellerResponse;
import com.ecommerce.MCA.model.Seller;
import com.ecommerce.MCA.repository.SellerRepository;
import com.ecommerce.MCA.transformer.SellerTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public SellerResponse addSeller(SellerRequest sellerRequest) {
        Seller seller = SellerTransformer.sellerRequestToSeller(sellerRequest);
        Seller savedSeller = sellerRepository.save(seller);
        SellerResponse sellerResponse = SellerTransformer.sellerToSellerResponse(savedSeller);
        return sellerResponse;
    }
}
