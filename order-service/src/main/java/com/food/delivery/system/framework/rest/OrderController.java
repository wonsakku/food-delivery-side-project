package com.food.delivery.system.framework.rest;


import com.food.delivery.system.application.ports.input.OrderService;
import com.food.delivery.system.application.ports.input.dto.CreateOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/orders")
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public void createOrder(@RequestBody @Validated CreateOrder createOrder){
        orderService.createOrder(createOrder);
    }

}
