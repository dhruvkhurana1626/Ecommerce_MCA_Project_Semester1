package com.ecommerce.MCA.transformer;

import com.ecommerce.MCA.dto.response.CustomerResponse;
import com.ecommerce.MCA.dto.response.OrderResponse;
import com.ecommerce.MCA.model.Orderentity;

public class OrderTransformer {

    public static OrderResponse orderToOrderResponse(Orderentity orderentity){
        return OrderResponse.builder()
                .id(orderentity.getId())
                .value(orderentity.getValue())
                .orderstatus(orderentity.getOrderstatus())
                .customerResponse(CustomerTransformer.customerToCustomerResponse(orderentity.getCustomer()))
                .build();
    }
}
