package com.invo.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by INvo
 * on 2020/11/18.
 */
@EnableEurekaClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ServiceOrderEurekaMain {
    public static void main(String[] args) {
        SpringApplication.run(ServiceOrderEurekaMain.class, args);
    }
}
