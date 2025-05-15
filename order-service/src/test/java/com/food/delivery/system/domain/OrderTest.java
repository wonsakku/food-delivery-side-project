package com.food.delivery.system.domain;

import com.food.delivery.system.domain.dto.CreateOrder;
import com.food.delivery.system.domain.exception.OrderDomainException;
import com.food.delivery.system.valueobject.Money;
import com.food.delivery.system.valueobject.OrderStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class OrderTest {

    CreateOrder createOrder;

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
    }


    @Test
    @DisplayName("주문을 생성하면 합계금액을 구할 수 있다.")
    void calculate_Order_Total_Price(){
        // given
        Order order = Order.createOrder(LocalDateTime.now(), OrderStatus.PENDING, createOrder);

        // when
        BigDecimal totalPrice = order.getTotalPrice();

        // then
        Assertions.assertThat(totalPrice).isEqualTo(new BigDecimal(36_000L));
    }

    @Test
    @DisplayName("주문 상세내역이 없으면 주문 생성 시 예외를 던진다.")
    void throw_Exception_When_No_OrderDetail(){

        // given
        CreateOrder detail = new CreateOrder();

        // when
        Assertions.assertThatThrownBy(
                () -> Order.createOrder(LocalDateTime.now(), OrderStatus.PENDING, detail)
        ).isInstanceOf(OrderDomainException.class);
    }

}