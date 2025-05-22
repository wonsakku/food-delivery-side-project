package com.food.delivery.system.application.service;

import com.food.delivery.system.domain.model.Order;
import com.food.delivery.system.event.Event;
import com.food.delivery.system.event.payload.OrderCreatedEventPayload;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OrderEventMapper {

    public Event<OrderCreatedEventPayload> toOrderCreatedEvent(Order order){
        OrderCreatedEventPayload payload = OrderCreatedEventPayload.builder()
                .build();
        return new Event<>(UUID.randomUUID().toString(), payload);
    }
}
