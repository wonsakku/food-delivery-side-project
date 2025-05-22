package com.food.delivery.system.application.service;

import com.food.delivery.system.application.ports.output.publisher.EventPublisher;
import com.food.delivery.system.domain.model.Order;
import com.food.delivery.system.event.Event;
import com.food.delivery.system.event.payload.OrderCreatedEventPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderCreatedEventProcessor {

    private final EventPublisher eventPublisher;
    private final OrderEventMapper orderEventMapper;

    public void process(Order order) {
        Event<OrderCreatedEventPayload> orderCreatedEventPayloadEvent = orderEventMapper.toOrderCreatedEvent(order);
        eventPublisher.publish(orderCreatedEventPayloadEvent);
    }
}
