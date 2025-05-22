package com.food.delivery.system.framework.persistence;

import com.food.delivery.system.domain.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressJpaRepository extends JpaRepository<Address, Long> {
}
