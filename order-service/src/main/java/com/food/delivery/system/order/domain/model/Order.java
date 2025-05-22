package com.food.delivery.system.order.domain.model;

import com.food.delivery.system.order.domain.exception.OrderDomainException;
import com.food.delivery.system.order.valueobject.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "user_address_id") // 이 테이블에 외래키를 둠
    private UserAddress address;

    @Column
    private LocalDateTime orderDateTime;

    @Column
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    public static Order createOrder(LocalDateTime orderDateTime,
                                    OrderStatus orderStatus,
                                    UserAddress userAddress,
                                    Long userId,
                                    List<OrderItem> orderItems){

        if(orderItems == null || orderItems.isEmpty()){
            throw new OrderDomainException("주문 상세 내역이 존재하지 않습니다.");
        }

        Order order = Order.builder()
                .userId(userId)
                .address(userAddress)
                .orderDateTime(orderDateTime)
                .orderStatus(orderStatus)
                .orderItems(orderItems)
                .build();

        // 양방향 연관관계 설정, 영속성 전이시키기
//        orderItems.forEach(orderItem -> orderItem.setOrder(order));
        return order;
    }

    public BigDecimal getTotalPrice(){
        return orderItems.stream()
                .map(orderItem -> BigDecimal.valueOf(orderItem.getPricePer().longValue() * orderItem.getProductCount().longValue()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
