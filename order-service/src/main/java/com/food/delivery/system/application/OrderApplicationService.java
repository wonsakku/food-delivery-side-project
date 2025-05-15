package com.food.delivery.system.application;

import com.food.delivery.system.domain.Order;
import com.food.delivery.system.domain.dto.CreateOrder;
import com.food.delivery.system.domain.service.OrderDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderApplicationService {

    private final OrderDomainService orderDomainService;

    public void createOrder(CreateOrder createOrder){
        Order order = orderDomainService.createOrder(LocalDateTime.now(), createOrder);

    }

}
