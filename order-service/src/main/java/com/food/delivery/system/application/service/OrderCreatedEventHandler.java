package com.food.delivery.system.application.service;

import com.food.delivery.system.application.ports.output.publisher.EventPublisher;
import com.food.delivery.system.event.Event;
import com.food.delivery.system.event.payload.OrderCreatedEventPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class OrderCreatedEventHandler {

    private final OutboxRepository outboxRepository;
    private final EventPublisher eventPublisher;

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void saveOrderCreateOutbox(Event<OrderCreatedEventPayload> orderCreatedEventPayloadEvent){
        outboxRepository.save(orderCreatedEventPayloadEvent);
    }

    @TransactionalEventListener
    public void publish(Event<OrderCreatedEventPayload> orderCreatedEventPayloadEvent){
        eventPublisher.publish(orderCreatedEventPayloadEvent);
    }

}
