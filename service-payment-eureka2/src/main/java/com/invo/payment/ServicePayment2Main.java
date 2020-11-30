package com.invo.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by INvo
 * on 2020/11/16.
 */
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class ServicePayment2Main {
    public static void main(String[] args) {
        SpringApplication.run(ServicePayment2Main.class, args);
    }
}
