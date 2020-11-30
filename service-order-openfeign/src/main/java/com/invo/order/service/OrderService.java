package com.invo.order.service;

import com.invo.api.entity.CommonResult;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by INvo
 * on 2020/11/26.
 */
@Component
@FeignClient(value = "com.invo.payment.service-payment-hystrix")
public interface OrderService {

    @GetMapping(value = "/payment/get/all")
     CommonResult getPayment();

    @GetMapping(value = "/payment/test")
     String Test();

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/hystrix/bad/{id}")
    String paymentInfo_Timeout(@PathVariable("id") Integer id);
}
