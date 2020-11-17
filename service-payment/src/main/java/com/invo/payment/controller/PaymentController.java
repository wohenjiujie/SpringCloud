package com.invo.payment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import com.invo.payment.entity.CommonResult;
import com.invo.payment.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import com.invo.payment.service.PaymentService;

/**
 * Created by INvo
 * on 2020/11/17.
 */
@RestController
@Slf4j
public class PaymentController {
    private static final String LOG_INFO = "*****INvo For Log Result:";
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        log.info(LOG_INFO + result);
        if (result > 0) {
            return new CommonResult(200, "Success", result);
        } else {
            return new CommonResult(444, "Failure", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        Payment result = paymentService.getPayment(id);
        log.info(LOG_INFO + result);
        if (null != result) {
            return new CommonResult(200, "Success", result);
        } else {
            return new CommonResult(444, "Failure", null);
        }
    }
}
