package com.food.delivery.system.order.application.ports.output;


import com.food.delivery.system.order.domain.model.UserAddress;

import java.util.Optional;

public interface UserAddressRepository {

    UserAddress save(UserAddress userAddress);

    Optional<UserAddress> findById(Long userAddressId);
}
