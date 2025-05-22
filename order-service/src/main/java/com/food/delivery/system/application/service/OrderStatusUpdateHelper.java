package com.food.delivery.system.application.service;

import com.food.delivery.system.application.ports.output.OrderRepository;
import com.food.delivery.system.domain.exception.OrderDomainException;
import com.food.delivery.system.domain.model.Order;
import com.food.delivery.system.valueobject.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class OrderStatusUpdateHelper {

    private final OrderRepository orderRepository;

    @Transactional
    public void markOrderPaid(Long orderId){
        updateOrderStatus(orderId, OrderStatus.PAID);
    }

    @Transactional
    public void markOrderPaymentFailed(Long orderId){
        updateOrderStatus(orderId, OrderStatus.PAYMENT_FAIL);
    }



    private void updateOrderStatus(Long orderId, OrderStatus orderStatus){
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderDomainException("존재하지 않는 주문입니다. : orderId=" + orderId));
        order.changeOrderStatus(orderStatus);
    }

}
