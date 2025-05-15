package com.food.delivery.system.order.framework.persistence;

import com.food.delivery.system.order.application.ports.output.UserAddressRepository;
import com.food.delivery.system.order.domain.model.UserAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserAddressRepositoryImpl implements UserAddressRepository {

    private final UserAddressJpaRepository userAddressJpaRepository;

    @Override
    public Optional<UserAddress> findById(Long userAddressId) {
        return userAddressJpaRepository.findById(userAddressId);
    }

}
