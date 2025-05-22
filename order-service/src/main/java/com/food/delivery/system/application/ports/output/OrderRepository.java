package com.food.delivery.system.application.ports.output;

import com.food.delivery.system.domain.model.Order;

import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);

    Optional<Order> findById(Long orderId);
}
