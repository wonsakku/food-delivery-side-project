package com.food.delivery.system.valueobject;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {
    PENDING("주문접수"),
    PAID("결제완료"),
    APPROVED("주문완료"),
    CANCELLING("취소중"),
    CANCELLED("주문취소"),
    ;

    private final String description;
}
