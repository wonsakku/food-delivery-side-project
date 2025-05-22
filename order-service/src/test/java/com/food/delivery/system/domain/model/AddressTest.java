package com.food.delivery.system.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AddressTest {

    @Test
    @DisplayName("팩토리 메서드로 Address가 생성된다.")
    void createAddressTest(){

        long userId = 1L;
        String addressBasic = "addressBasic";
        String addressDetail = "addressDetail";
        String description = "description";
        Address address = Address.newAddress(userId,
                addressBasic,
                addressDetail,
                description
        );

        assertThat(address.getUserId()).isEqualTo(userId);
        assertThat(address.getAddressBasic()).isEqualTo(addressBasic);
        assertThat(address.getAddressDetail()).isEqualTo(addressDetail);
        assertThat(address.getDescription()).isEqualTo(description);
    }

}