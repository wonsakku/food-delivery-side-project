package com.food.delivery.system.application.service;

import com.food.delivery.system.application.ports.input.PaymentRequestHelper;
import com.food.delivery.system.application.ports.input.dto.PaymentRequest;
import com.food.delivery.system.application.ports.input.dto.PaymentResponse;
import com.food.delivery.system.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class OrderPaymentProcessor {

    private final OrderPaymentMapper orderPaymentMapper;
    private final PaymentRequestHelper paymentRequestHelper;
    private final OrderStatusUpdateHelper orderStatusUpdateHelper;

    @Transactional
    public boolean pay(Order order){

        try{
            PaymentRequest paymentRequest = orderPaymentMapper.orderToPaymentRequest(order);
            PaymentResponse paymentResponse = paymentRequestHelper.requestPayment(paymentRequest);
            orderStatusUpdateHelper.markOrderPaid(order.getId());
            return true;
        }catch (Exception e){
            orderStatusUpdateHelper.markOrderPaymentFailed(order.getId());
            return false;
        }
    }
}
