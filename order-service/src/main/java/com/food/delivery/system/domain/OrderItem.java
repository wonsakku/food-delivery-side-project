package com.food.delivery.system.domain;

import com.food.delivery.system.valueobject.Money;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")  // FK 컬럼명 명시
    private Order order;

    @Column
    private Long productId;

    @Column
    private Integer productCount;

    @Column
    private BigDecimal pricePer;

    @Column
    private BigDecimal totalPrice;


    void setOrder(Order order) {
        this.order = order;
    }
}
