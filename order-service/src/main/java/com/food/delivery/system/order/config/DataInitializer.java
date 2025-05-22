package com.food.delivery.system.order.config;

import com.food.delivery.system.order.application.ports.output.UserAddressRepository;
import com.food.delivery.system.order.domain.model.UserAddress;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(UserAddressRepository userAddressRepository){
        return args -> {
            userAddressRepository.save(UserAddress.newAddress("서울특별시 강남구 봉은사로", "테스트주소", "테스트1"));
            userAddressRepository.save(UserAddress.newAddress("경기도 성남시 분당구", "테스트주소2", "테스트2"));
        };
    }

}
