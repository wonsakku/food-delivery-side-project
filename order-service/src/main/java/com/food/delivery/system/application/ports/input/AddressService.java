package com.food.delivery.system.application.ports.input;

import com.food.delivery.system.application.ports.input.dto.CreateAddressRequest;

public interface AddressService {

    Long createNewAddress(CreateAddressRequest createAddressRequest);
}
