package com.food.delivery.system.application.ports.input;

import com.food.delivery.system.domain.model.Order;
import com.food.delivery.system.application.ports.input.dto.CreateOrder;

public interface OrderService {

    Long createOrder(CreateOrder dto);

}
