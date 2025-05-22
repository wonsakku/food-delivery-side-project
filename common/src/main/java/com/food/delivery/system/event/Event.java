package com.food.delivery.system.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Event <T extends EventPayload>{
    private String sagaId;
    private T payload;
}
