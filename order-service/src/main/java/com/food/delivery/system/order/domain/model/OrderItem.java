package com.food.delivery.system.order.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")  // FK 컬럼명 명시
    private Order order;

    @Column
    private Long productId;

    @Column
    private Integer productCount;

    @Column
    private BigDecimal pricePer;


    public static OrderItem create(Long productId, Integer productCount, BigDecimal pricePer){
        return OrderItem.builder()
                .productId(productId)
                .productCount(productCount)
                .pricePer(pricePer)
                .build();
    }

    void setOrder(Order order) {
        this.order = order;
    }
}
