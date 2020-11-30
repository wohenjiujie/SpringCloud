package com.invo.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by INvo
 * on 2020/11/20.
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@EnableDiscoveryClient  //Zookeeper & Consul
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
public class ServicePaymentHystrixMain {
    public static void main(String[] args) {
        SpringApplication.run(ServicePaymentHystrixMain.class, args);
    }
}
