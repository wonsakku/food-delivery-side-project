package com.food.delivery.system.order.application.ports.output;

import com.food.delivery.system.order.domain.model.OrderItem;

public interface OrderItemRepository {
    OrderItem save(OrderItem orderItem);
}
