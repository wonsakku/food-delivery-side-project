package com.food.delivery.system.application.ports.output;


import com.food.delivery.system.domain.model.Address;

import java.util.Optional;

public interface AddressRepository {

    Address save(Address address);

    Optional<Address> findById(Long userAddressId);
}
