package com.food.delivery.system.application.service;

import com.food.delivery.system.application.ports.input.AddressService;
import com.food.delivery.system.application.ports.input.dto.CreateAddressRequest;
import com.food.delivery.system.domain.model.Address;
import com.food.delivery.system.framework.persistence.AddressJpaRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AddressServiceImplTest {

    @Autowired
    AddressJpaRepository addressJpaRepository;

    @Autowired
    AddressService addressService;

    @Autowired
    EntityManager em;


    @Test
    @DisplayName("새로운 주소를 생성하면 조회할 수 있다.")
    @Transactional
    void createAddressTest(){
        // given
        CreateAddressRequest dto = new CreateAddressRequest(1L, "addressBasic", "addressDetail", "description");

        // when
        Long newAddressId = addressService.createNewAddress(dto);
        em.flush();
        em.clear();

        Address address = addressJpaRepository.findById(newAddressId)
                .orElseThrow();

        // then
        assertThat(address.getId()).isEqualTo(newAddressId);
        assertThat(address.getUserId()).isEqualTo(dto.getUserId());
        assertThat(address.getAddressBasic()).isEqualTo(dto.getAddressBasic());
        assertThat(address.getAddressDetail()).isEqualTo(dto.getAddressDetail());
        assertThat(address.isDeleted()).isFalse();
    }

}