package com.food.delivery.system.order.framework.persistence;

import com.food.delivery.system.order.domain.model.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressJpaRepository extends JpaRepository<UserAddress, Long> {
}
