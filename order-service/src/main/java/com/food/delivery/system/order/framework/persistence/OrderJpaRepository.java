package com.food.delivery.system.order.framework.persistence;

import com.food.delivery.system.order.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<Order, Long> {
}
