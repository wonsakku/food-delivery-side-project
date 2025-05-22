package com.food.delivery.system.order.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String addressBasic;

    @Column
    private String addressDetail;

    @Column
    private String description;

    @Column
    private boolean deleted;

    public static UserAddress newAddress(String addressBasic, String addressDetail, String description){
        return UserAddress.builder()
                .addressBasic(addressBasic)
                .addressDetail(addressDetail)
                .description(description)
                .deleted(false)
                .build();
    }

}
