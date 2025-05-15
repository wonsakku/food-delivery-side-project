package com.food.delivery.system.order.application.ports.output;

import com.food.delivery.system.order.domain.model.Order;

public interface OrderRepository {

    Order save(Order order);
}
