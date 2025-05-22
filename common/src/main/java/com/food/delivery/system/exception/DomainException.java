package com.food.delivery.system.exception;

public class DomainException extends RuntimeException{

    public DomainException(String message) {
        super(message);
    }
}
