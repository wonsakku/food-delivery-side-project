package com.food.delivery.system.application.ports.input.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAddressRequest {

    private Long userId;
    private String addressBasic;
    private String addressDetail;
    private String description;

}
