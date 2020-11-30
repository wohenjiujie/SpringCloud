package com.invo.order.controller;


import com.invo.api.entity.CommonResult;
import com.invo.order.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by INvo
 * on 2020/11/18.
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderController {
    //    public static final String ORDER_URL = "http://localhost:8002";
    public static final String ORDER_URL = "http://COM.INVO.PAYMENT.SERVICE-PAYMENT";
    @Resource
    private OrderService orderService;

    @GetMapping("/consumer/order/get/all")
    public CommonResult getPayment() {
        return orderService.getPayment();
    }

    @GetMapping(value = "/payment/tests")
    public String Test() {
        return orderService.Test();
    }
    @GetMapping(value = "/consumer/ok/{id}")
    public String paymentInfo_OK(@PathVariable(value = "id") Integer id) {
        String result = orderService.paymentInfo_OK(id);
        log.info("****INvo For Result:" + result);
        return result;
    }

    @GetMapping(value = "/consumer/bad/{id}")
    public String paymentInfo_Timeout(@PathVariable(value = "id") Integer id) {
        String result = orderService.paymentInfo_Timeout(id);
        log.info("****INvo For Result:" + result);
        return result;
    }

    private String payment_Global_FallbackMethod() {
        return "Global Message: Order Error";
    }
}
