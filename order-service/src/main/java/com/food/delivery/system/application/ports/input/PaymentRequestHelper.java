package com.food.delivery.system.application.ports.input;

import com.food.delivery.system.application.ports.input.dto.PaymentRequest;
import com.food.delivery.system.application.ports.input.dto.PaymentResponse;

public interface PaymentRequestHelper {
    PaymentResponse requestPayment(PaymentRequest request);
}
