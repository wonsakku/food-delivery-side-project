package com.food.delivery.system.application.ports.output;

import com.food.delivery.system.domain.model.OrderItem;

public interface OrderItemRepository {
    OrderItem save(OrderItem orderItem);
}
