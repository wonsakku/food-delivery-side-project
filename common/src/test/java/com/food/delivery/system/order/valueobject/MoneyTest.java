package com.food.delivery.system.order.valueobject;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class MoneyTest {

    @Test
    public void createTest(){
        BigDecimal bigDecimal = new BigDecimal(10_000);
        Assertions.assertThat(bigDecimal.intValue()).isEqualTo(10_000);
    }

}