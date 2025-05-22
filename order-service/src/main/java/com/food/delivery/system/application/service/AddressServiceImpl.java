package com.food.delivery.system.application.service;

import com.food.delivery.system.application.ports.input.dto.CreateAddressRequest;
import com.food.delivery.system.application.ports.input.AddressService;
import com.food.delivery.system.domain.model.Address;
import com.food.delivery.system.framework.persistence.AddressJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressJpaRepository addressJpaRepository;

    @Override
    @Transactional
    public Long createNewAddress(CreateAddressRequest dto) {
        Address address = Address.newAddress(
                dto.getUserId(),
                dto.getAddressBasic(),
                dto.getAddressDetail(),
                dto.getDescription()
        );
        Address save = addressJpaRepository.save(address);
        return save.getId();
    }


}
