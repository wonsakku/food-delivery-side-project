package com.food.delivery.system.order.application.ports.input.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrder {

    private Long userId;
    private Long userAddressId;
    private List<OrderDetail> orderDetails;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderDetail {
        private Long productId;
        private Integer productCount;
        private Long productPrice;
    }
}
