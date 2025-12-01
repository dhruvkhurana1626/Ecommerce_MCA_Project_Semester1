package com.ecommerce.MCA.exception;

public class SellerNotFound extends RuntimeException {
    public SellerNotFound(String message) {
        super(message);
    }
}
