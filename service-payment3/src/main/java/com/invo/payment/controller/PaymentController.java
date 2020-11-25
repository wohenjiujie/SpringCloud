package com.invo.payment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by INvo
 * on 2020/11/20.
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/zookeeper")
    public String getZookeeperInfo() {
        return "Invoker with Zookeeper :"+serverPort+"\t"+UUID.randomUUID().toString();
    }

    @RequestMapping(value = "/payment/consul")
    public String getConsulInfo() {
        return "Invoker with Consul :"+serverPort+"\t"+UUID.randomUUID().toString();
    }
}
