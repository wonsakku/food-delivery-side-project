package com.food.delivery.system.order.application.service;

import com.food.delivery.system.order.application.ports.input.dto.CreateOrder;
import com.food.delivery.system.order.application.ports.output.OrderRepository;
import com.food.delivery.system.order.application.ports.output.UserAddressRepository;
import com.food.delivery.system.order.domain.model.Order;
import com.food.delivery.system.order.domain.model.UserAddress;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private UserAddressRepository userAddressRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    private CreateOrder createOrder;

    @BeforeEach
    void setUp() {
        List<CreateOrder.OrderDetail> details = List.of(
                new CreateOrder.OrderDetail(1L, 2, 10_000L),
                new CreateOrder.OrderDetail(2L, 1, 3_000L)
        );
        createOrder = new CreateOrder(1L, 1L, details);
    }

    @Test
    void createOrder_정상_생성됨() {
        // given
        UserAddress userAddress = new UserAddress(1L, "서울", "강남", "101동", true);
        when(userAddressRepository.findById(any())).thenReturn(Optional.of(userAddress));

        Order savedOrder = mock(Order.class);
        when(orderRepository.save(any())).thenReturn(savedOrder);

        // when
        Order result = orderService.createOrder(createOrder);

        // then
        verify(orderRepository).save(any(Order.class));
        assertThat(result).isEqualTo(savedOrder);
    }


}





