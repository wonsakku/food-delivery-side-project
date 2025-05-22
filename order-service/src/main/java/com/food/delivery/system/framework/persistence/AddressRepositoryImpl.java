package com.food.delivery.system.framework.persistence;

import com.food.delivery.system.application.ports.output.AddressRepository;
import com.food.delivery.system.domain.model.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AddressRepositoryImpl implements AddressRepository {

    private final AddressJpaRepository addressJpaRepository;

    @Override
    public Address save(Address address) {
        return addressJpaRepository.save(address);
    }

    @Override
    public Optional<Address> findById(Long userAddressId) {
        return addressJpaRepository.findById(userAddressId);
    }

}
