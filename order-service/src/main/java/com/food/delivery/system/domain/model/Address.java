package com.food.delivery.system.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @Column
    private String addressBasic;

    @Column
    private String addressDetail;

    @Column
    private String description;

    @Column
    private boolean deleted;

    public static Address newAddress(Long userId, String addressBasic, String addressDetail, String description){
        return Address.builder()
                .userId(userId)
                .addressBasic(addressBasic)
                .addressDetail(addressDetail)
                .description(description)
                .deleted(false)
                .build();
    }

}
