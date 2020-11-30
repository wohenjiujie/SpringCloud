package com.invo.payment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

/**
 * Created by INvo
 * on 2020/11/26.
 */
@Configuration
//@FeignClient(value = "com.invo.payment.service-payment-hystrix")
public class FeignConfig {
    @Bean
    Logger.Level level() {
        return Logger.Level.FULL;
    }
}
