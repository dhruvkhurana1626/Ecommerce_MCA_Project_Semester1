package com.ecommerce.MCA.service;

import com.ecommerce.MCA.dto.request.ProductRequest;
import com.ecommerce.MCA.dto.response.ProductResponse;
import com.ecommerce.MCA.exception.SellerNotFound;
import com.ecommerce.MCA.model.Product;
import com.ecommerce.MCA.model.Seller;
import com.ecommerce.MCA.repository.ProductRepository;
import com.ecommerce.MCA.repository.SellerRepository;
import com.ecommerce.MCA.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    ProductRepository productRepository;

    public ProductResponse addProduct(int sellerId, ProductRequest productRequest) {
        Optional<Seller> sellerOptional = sellerRepository.findById(sellerId);
        if(sellerOptional.isEmpty()){
            throw new SellerNotFound("Invalid Seller ID");
        }

        //DTO to Entity
        Product product = ProductTransformer.productRequestToProduct(productRequest);

        //Set the Relationship
        Seller seller = sellerOptional.get();
        seller.getProducts().add(product);
        product.setSeller(seller);

        //Save Seller + Product
        Seller savedSeller = sellerRepository.save(seller);

        //Entity to DTO
        int size = savedSeller.getProducts().size();
        Product savedProduct = savedSeller.getProducts().get(size-1);
        return ProductTransformer.productToProductResponse(savedProduct);
    }
}
