package com.food.delivery.system.order.application.ports.input;

import com.food.delivery.system.order.domain.model.Order;
import com.food.delivery.system.order.application.ports.input.dto.CreateOrder;

public interface OrderService {

    Order createOrder(CreateOrder dto);

}
