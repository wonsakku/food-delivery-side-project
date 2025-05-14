package com.food.delivery.system.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDetails {

    private Long userId;
    private Long userAddressId;
    private List<CreateOrderDetail> createOrderDetails;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateOrderDetail {
        private Long productId;
        private Integer productCount;
        private Long productPrice;
    }
}
