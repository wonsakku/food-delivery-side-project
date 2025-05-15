package com.food.delivery.system.domain;

import com.food.delivery.system.domain.dto.CreateOrder;
import com.food.delivery.system.domain.exception.OrderDomainException;
import com.food.delivery.system.valueobject.Money;
import com.food.delivery.system.valueobject.OrderStatus;
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
@Table
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @ManyToOne(cascade = CascadeType.ALL)
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
                                    CreateOrder createOrder){

        List<CreateOrder.OrderDetail> orderDetails = createOrder.getOrderDetails();
        if(orderDetails == null || orderDetails.isEmpty()){
            throw new OrderDomainException("주문 상세 내역이 없습니다.");
        }

        Order order = Order.builder()
                .userId(createOrder.getUserId())
                .address(createOrder.getUserAddressId())
                .orderDateTime(orderDateTime)
                .orderStatus(orderStatus)
                .build();

        for (CreateOrder.OrderDetail detail : orderDetails) {
            OrderItem item = OrderItem.builder()
                    .order(order)
                    .productId(detail.getProductId())
                    .productCount(detail.getProductCount())
                    .pricePer(new Money(detail.getProductPrice()).getAmount())
                    .totalPrice(new Money(detail.getProductPrice() * detail.getProductCount()).getAmount())
                    .build();

            order.orderItems.add(item);
        }

        return order;
    }

    public BigDecimal getTotalPrice(){
        return orderItems.stream()
                .map(OrderItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


}
