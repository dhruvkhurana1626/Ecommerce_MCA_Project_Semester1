package com.ecommerce.MCA.service;

import com.ecommerce.MCA.dto.response.OrderResponse;
import com.ecommerce.MCA.enums.Orderstatus;
import com.ecommerce.MCA.exception.CustomerNotFound;
import com.ecommerce.MCA.exception.ProductNotFound;
import com.ecommerce.MCA.model.Customer;
import com.ecommerce.MCA.model.Orderentity;
import com.ecommerce.MCA.model.Product;
import com.ecommerce.MCA.repository.CustomerRepository;
import com.ecommerce.MCA.repository.OrderRepository;
import com.ecommerce.MCA.repository.ProductRepository;
import com.ecommerce.MCA.transformer.OrderTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderResponse addOrder(int customerId, int productId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFound("Customer id is not Valid");
        }

        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFound("Product ID is not valid");
        }

        Customer customer = optionalCustomer.get();
        Product product = optionalProduct.get();

        Orderentity order = new Orderentity();
        order.setValue(product.getPrice());
        order.setOrderstatus(Orderstatus.PROCESSING);

        order.setCustomer(customer);
        order.getProducts().add(product);

        Orderentity savedOrder = orderRepository.save(order);

        return OrderTransformer.orderToOrderResponse(savedOrder);
    }
}
