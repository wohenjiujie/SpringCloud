package com.invo.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by INvo
 * on 2020/11/18.
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced  //使用LoadBalanced注解赋予了RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
