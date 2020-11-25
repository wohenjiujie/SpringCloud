package com.invo.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by INvo
 * on 2020/11/20.
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient  //Zookeeper & Consul
public class ServicePayment3Main {
    public static void main(String[] args) {
        SpringApplication.run(ServicePayment3Main.class, args);
    }
}
