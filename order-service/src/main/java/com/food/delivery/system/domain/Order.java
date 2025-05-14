package com.food.delivery.system.domain;

import com.food.delivery.system.domain.dto.CreateOrderDetails;
import com.food.delivery.system.domain.exception.OrderDomainException;
import com.food.delivery.system.valueobject.Money;
import com.food.delivery.system.valueobject.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long orderId;
    private Long userId;
    private Long userAddressId;
    private LocalDateTime orderDateTime;
    private OrderStatus orderStatus;
    private List<OrderDetail> orderDetails;

    public static Order createOrder(LocalDateTime orderDateTime,
                                    OrderStatus orderStatus,
                                    CreateOrderDetails createOrderDetails){

        List<CreateOrderDetails.CreateOrderDetail> details = createOrderDetails.getCreateOrderDetails();
        if(details == null || details.isEmpty()){
            throw new OrderDomainException("주문 상세 내역이 없습니다.");
        }

        List<OrderDetail> orderDetails = details.stream()
                .map(d -> OrderDetail.builder()
                        .productId(d.getProductId())
                        .productCount(d.getProductCount())
                        .pricePer(new Money(d.getProductPrice()))
                        .totalPrice(new Money(d.getProductPrice() * d.getProductCount()))
                        .build()
        ).toList();

        return Order.builder()
                .userId(createOrderDetails.getUserId())
                .userAddressId(createOrderDetails.getUserAddressId())
                .orderDateTime(orderDateTime)
                .orderStatus(orderStatus)
                .orderDetails(orderDetails)
                .build();
    }

    public Money getTotalPrice(){
        return orderDetails.stream()
                .map(OrderDetail::getTotalPrice)
                .reduce(Money.ZERO, Money::add);
    }


}
