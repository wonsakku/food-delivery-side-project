package com.food.delivery.system.event.payload;

import com.food.delivery.system.event.EventPayload;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreatedEventPayload implements EventPayload {
    private Long orderId;
    private List<OrderDetail> orderDetails;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderDetail {
        private Long itemId;
        private BigDecimal price;
        private Integer count;
    }
}
