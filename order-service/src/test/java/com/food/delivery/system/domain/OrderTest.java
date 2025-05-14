package com.food.delivery.system.domain;

import com.food.delivery.system.domain.dto.CreateOrderDetails;
import com.food.delivery.system.domain.exception.OrderDomainException;
import com.food.delivery.system.valueobject.Money;
import com.food.delivery.system.valueobject.OrderStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

public class OrderTest {

    CreateOrderDetails createOrderDetails;

    @BeforeEach
    void init(){
        createOrderDetails = new CreateOrderDetails(
                1L,
                1L,
                Arrays.asList(
                        new CreateOrderDetails.CreateOrderDetail(1L, 1, 10_000L),
                        new CreateOrderDetails.CreateOrderDetail(2L, 2, 3_000L),
                        new CreateOrderDetails.CreateOrderDetail(3L, 5, 4_000L)
                )
        );
    }


    @Test
    @DisplayName("주문을 생성하면 합계금액을 구할 수 있다.")
    void calculate_Order_Total_Price(){
        // given
        Order order = Order.createOrder(LocalDateTime.now(), OrderStatus.PENDING, createOrderDetails);

        // when
        Money totalPrice = order.getTotalPrice();

        // then
        Assertions.assertThat(totalPrice).isEqualTo(new Money(36_000L));
    }

    @Test
    @DisplayName("주문 상세내역이 없으면 주문 생성 시 예외를 던진다.")
    void throw_Exception_When_No_OrderDetail(){

        // given
        CreateOrderDetails detail = new CreateOrderDetails();

        // when
        Assertions.assertThatThrownBy(
                () -> Order.createOrder(LocalDateTime.now(), OrderStatus.PENDING, detail)
        ).isInstanceOf(OrderDomainException.class);
    }

}