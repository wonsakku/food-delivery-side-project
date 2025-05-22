package com.food.delivery.system.application.service;

import com.food.delivery.system.application.ports.input.dto.CreateOrder;
import com.food.delivery.system.application.ports.output.OrderRepository;
import com.food.delivery.system.application.ports.output.AddressRepository;
import com.food.delivery.system.domain.exception.OrderDomainException;
import com.food.delivery.system.domain.model.Order;
import com.food.delivery.system.domain.model.OrderItem;
import com.food.delivery.system.domain.model.Address;
import com.food.delivery.system.valueobject.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderCreatePersistenceHelper {
    private final OrderRepository orderRepository;
    private final AddressRepository addressRepository;

    @Transactional
    public Order createOrder(CreateOrder dto) {

        validateCreateOrder(dto);

        Address address = addressRepository.findById(dto.getUserAddressId())
                .orElseThrow(() -> new OrderDomainException("존재하지 않는 주소입니다."));

        List<OrderItem> orderItems = dto.getOrderDetails().stream()
                .map(detail -> OrderItem.create(detail.getProductId(), detail.getProductCount(), BigDecimal.valueOf(detail.getProductPrice())))
                .toList();
        Order order = Order.createOrder(LocalDateTime.now(), OrderStatus.PENDING, address, dto.getUserId(), orderItems);

        return orderRepository.save(order);
    }

    private void validateCreateOrder(CreateOrder dto) {
        List<CreateOrder.OrderDetail> orderDetails = dto.getOrderDetails();
        if(orderDetails == null || orderDetails.isEmpty()){
            throw new OrderDomainException("주문 상세내역이 존재하지 않습니다.");
        }
    }

}
