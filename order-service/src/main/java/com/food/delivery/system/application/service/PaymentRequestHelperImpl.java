package com.food.delivery.system.application.service;

import com.food.delivery.system.application.ports.input.PaymentRequestHelper;
import com.food.delivery.system.application.ports.input.dto.PaymentRequest;
import com.food.delivery.system.application.ports.input.dto.PaymentResponse;
import org.springframework.stereotype.Component;

@Component
public class PaymentRequestHelperImpl implements PaymentRequestHelper {


    @Override
    public PaymentResponse requestPayment(PaymentRequest request) {
        return null;
    }
}
