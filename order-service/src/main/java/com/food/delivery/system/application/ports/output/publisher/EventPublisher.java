package com.food.delivery.system.application.ports.output.publisher;

import com.food.delivery.system.event.Event;
import com.food.delivery.system.event.EventPayload;

public interface EventPublisher {
    <T extends EventPayload> void publish(Event<T> event);
}
