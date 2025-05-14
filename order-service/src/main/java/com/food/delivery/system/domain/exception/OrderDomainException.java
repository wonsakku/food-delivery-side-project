package com.food.delivery.system.domain.exception;

import com.food.delivery.system.exception.DomainException;

public class OrderDomainException extends DomainException {

    public OrderDomainException(String message) {
        super(message);
    }
}
