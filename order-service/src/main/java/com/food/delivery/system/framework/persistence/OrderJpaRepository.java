package com.food.delivery.system.framework.persistence;

import com.food.delivery.system.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<Order, Long> {
}
