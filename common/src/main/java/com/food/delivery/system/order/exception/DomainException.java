package com.food.delivery.system.order.exception;

public class DomainException extends RuntimeException{

    public DomainException(String message) {
        super(message);
    }
}
