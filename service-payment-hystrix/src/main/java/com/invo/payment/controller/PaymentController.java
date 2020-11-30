package com.invo.payment.controller;

import com.invo.payment.service.PaymentService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by INvo
 * on 2020/11/20.
 */
@RestController
@Slf4j
public class PaymentController {

@Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

   /* @RequestMapping(value = "/payment/zookeeper")
    public String getZookeeperInfo() {
        return "Invoker with Zookeeper :"+serverPort+"\t"+UUID.randomUUID().toString();
    }*/

    /*@RequestMapping(value = "/payment/consul")
    public String getConsulInfo() {
        return "Invoker with Consul :"+serverPort+"\t"+UUID.randomUUID().toString();
    }*/



    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        log.info("****INvo For Result:" + result);
        return result;
    }

    @GetMapping(value = "/payment/hystrix/bad/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_Timeout(id);
        log.info("****INvo For Result:" + result);
        return result;
    }

    @GetMapping(value = "/payment/test")
    public String Test() {
        return "****INvo For Result:Test For 81 Port";
    }


}
