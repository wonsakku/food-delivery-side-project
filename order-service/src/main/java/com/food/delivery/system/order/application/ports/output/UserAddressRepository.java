package com.food.delivery.system.order.application.ports.output;


import com.food.delivery.system.order.domain.model.UserAddress;

import java.util.Optional;

public interface UserAddressRepository {

    Optional<UserAddress> findById(Long userAddressId);
}
