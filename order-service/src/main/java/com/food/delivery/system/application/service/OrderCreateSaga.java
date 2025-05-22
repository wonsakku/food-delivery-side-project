package com.food.delivery.system.application.service;

import com.food.delivery.system.application.ports.input.dto.CreateOrder;
import com.food.delivery.system.domain.exception.OrderDomainException;
import com.food.delivery.system.domain.model.Order;
import com.food.delivery.system.event.Event;
import com.food.delivery.system.event.payload.OrderCreatedEventPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class OrderCreateSaga {

    private final OrderCreatePersistenceHelper orderCreatePersistenceHelper;
    private final OrderPaymentProcessor orderPaymentProcessor;
    private final OrderEventMapper orderEventMapper;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public Long createOrder(CreateOrder dto) {
        Order order = orderCreatePersistenceHelper.createOrder(dto);
        boolean success = orderPaymentProcessor.pay(order);
        if(!success){
            throw new OrderDomainException("결제가 실패했습니다. orderId : " + order.getId());
        }

        Event<OrderCreatedEventPayload> orderCreatedEventPayloadEvent = orderEventMapper.toOrderCreatedEvent(order);
        applicationEventPublisher.publishEvent(orderCreatedEventPayloadEvent);

        return order.getId();
    }
}
