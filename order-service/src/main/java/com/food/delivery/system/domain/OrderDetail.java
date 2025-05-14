package com.food.delivery.system.domain;

import com.food.delivery.system.valueobject.Money;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {

    private Long productId;
    private Integer productCount;
    private Money pricePer;
    private Money totalPrice;


}
