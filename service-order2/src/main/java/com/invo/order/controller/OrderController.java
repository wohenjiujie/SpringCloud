package com.invo.order.controller;


import com.invo.api.entity.CommonResult;
import com.invo.api.entity.Payment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by INvo
 * on 2020/11/18.
 */
@RestController
@Slf4j
public class OrderController {
//    public static final String ORDER_URL = "http://localhost:8002";
public static final String ORDER_URL = "http://COM.INVO.PAYMENT.SERVICE-PAYMENT";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/consul/order/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(ORDER_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/consul/order/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(ORDER_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/consul/order/get/all")
    public CommonResult<Payment> getPayment() {
        return restTemplate.getForObject(ORDER_URL + "/payment/get/all", CommonResult.class);
    }
}
