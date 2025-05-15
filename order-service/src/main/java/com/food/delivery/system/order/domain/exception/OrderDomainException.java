package com.food.delivery.system.order.domain.exception;

import com.food.delivery.system.order.exception.DomainException;

public class OrderDomainException extends DomainException {

    public OrderDomainException(String message) {
        super(message);
    }
}
