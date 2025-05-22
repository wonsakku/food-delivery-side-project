package com.food.delivery.system.application.service;

import com.food.delivery.system.application.ports.input.OrderService;
import com.food.delivery.system.application.ports.input.PaymentRequestHelper;
import com.food.delivery.system.application.ports.input.dto.PaymentRequest;
import com.food.delivery.system.application.ports.input.dto.PaymentResponse;
import com.food.delivery.system.domain.model.Order;
import com.food.delivery.system.application.ports.input.dto.CreateOrder;
import com.food.delivery.system.valueobject.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderCreateSaga orderCreateSaga;

    @Override
    public Long createOrder(CreateOrder dto) {
        return orderCreateSaga.createOrder(dto);
    }

}
