package com.food.delivery.system.application.ports.input.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrder {

    @NotNull
    private Long userId;

    @NotNull
    private Long userAddressId;

    @NotNull
    private List<@NotNull OrderDetail> orderDetails;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderDetail {

        @NotNull
        private Long productId;

        @NotNull
        @Min(1)
        private Integer productCount;

        @NotNull
        private Long productPrice;
    }
}
