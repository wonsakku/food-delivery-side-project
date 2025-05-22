package com.food.delivery.system.domain;

import com.food.delivery.system.application.ports.input.dto.CreateOrder;
import com.food.delivery.system.domain.model.Address;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

public class OrderTest {

    CreateOrder createOrder;
    Address address;

    @BeforeEach
    void init(){
        createOrder = new CreateOrder(
                1L,
                1L,
                Arrays.asList(
                        new CreateOrder.OrderDetail(1L, 1, 10_000L),
                        new CreateOrder.OrderDetail(2L, 2, 3_000L),
                        new CreateOrder.OrderDetail(3L, 5, 4_000L)
                )
        );

        address = new Address(1L, 1L, "서울 강남구 어딘가", "개발자아파트 777동 777호", "테스트", false);
    }




}