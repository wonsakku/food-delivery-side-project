package com.food.delivery.system.domain.service;

import com.food.delivery.system.domain.Order;
import com.food.delivery.system.domain.dto.CreateOrder;
import com.food.delivery.system.valueobject.OrderStatus;

import java.time.LocalDateTime;

public class OrderDomainService {

    public Order createOrder(LocalDateTime orderDateTime, CreateOrder dto){
        return Order.createOrder(orderDateTime, OrderStatus.PENDING, dto);
    }

}
