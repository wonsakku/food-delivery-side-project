package com.food.delivery.system.config;

import com.food.delivery.system.application.ports.output.AddressRepository;
import com.food.delivery.system.domain.model.Address;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(AddressRepository addressRepository){
        return args -> {
            addressRepository.save(Address.newAddress(1L, "서울특별시 강남구 봉은사로", "테스트주소", "테스트1"));
            addressRepository.save(Address.newAddress(1L, "경기도 성남시 분당구", "테스트주소2", "테스트2"));
        };
    }

}
