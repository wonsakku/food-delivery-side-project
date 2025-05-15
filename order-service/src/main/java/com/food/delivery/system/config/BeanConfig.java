package com.food.delivery.system.config;

import com.food.delivery.system.domain.service.OrderDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public OrderDomainService orderDomainService(){
        return new OrderDomainService();
    }
}
