package com.food.delivery.system.order.domain;

import com.food.delivery.system.order.application.ports.input.dto.CreateOrder;
import com.food.delivery.system.order.domain.exception.OrderDomainException;
import com.food.delivery.system.order.domain.model.Order;
import com.food.delivery.system.order.domain.model.UserAddress;
import com.food.delivery.system.order.valueobject.OrderStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class OrderTest {

    CreateOrder createOrder;
    UserAddress userAddress;

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

        userAddress = new UserAddress(1L, "서울 강남구 어딘가", "개발자아파트 777동 777호", "테스트", false);
    }




}