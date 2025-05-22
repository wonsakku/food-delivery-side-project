package com.food.delivery.system.application.service;

import com.food.delivery.system.application.ports.input.dto.PaymentRequest;
import com.food.delivery.system.domain.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderPaymentMapper {


    public PaymentRequest orderToPaymentRequest(Order order){
        return PaymentRequest.builder()
                .build();
    }

}
