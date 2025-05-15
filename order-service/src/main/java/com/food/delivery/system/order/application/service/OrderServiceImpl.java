package com.food.delivery.system.order.application.service;

import com.food.delivery.system.order.application.ports.input.OrderService;
import com.food.delivery.system.order.application.ports.input.dto.CreateOrder;
import com.food.delivery.system.order.application.ports.output.OrderRepository;
import com.food.delivery.system.order.application.ports.output.UserAddressRepository;
import com.food.delivery.system.order.domain.exception.OrderDomainException;
import com.food.delivery.system.order.domain.model.Order;
import com.food.delivery.system.order.domain.model.OrderItem;
import com.food.delivery.system.order.domain.model.UserAddress;
import com.food.delivery.system.order.valueobject.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserAddressRepository userAddressRepository;

    @Override
    @Transactional
    public Order createOrder(CreateOrder dto) {

        validateCreateOrder(dto);

        UserAddress userAddress = userAddressRepository.findById(dto.getUserAddressId())
                .orElseThrow(() -> new OrderDomainException("존재하지 않는 주소입니다."));


        List<OrderItem> orderItems = dto.getOrderDetails().stream()
                .map(detail -> OrderItem.create(detail.getProductId(), detail.getProductCount(), BigDecimal.valueOf(detail.getProductPrice())))
                .toList();
        Order order = Order.createOrder(LocalDateTime.now(), OrderStatus.PENDING, userAddress, dto.getUserId(), orderItems);

        return orderRepository.save(order);
    }

    private void validateCreateOrder(CreateOrder dto) {
        List<CreateOrder.OrderDetail> orderDetails = dto.getOrderDetails();
        if(orderDetails == null || orderDetails.isEmpty()){
            throw new OrderDomainException("주문 상세내역이 존재하지 않습니다.");
        }
    }
}
