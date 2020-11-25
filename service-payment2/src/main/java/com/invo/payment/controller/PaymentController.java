package com.invo.payment.controller;

import com.invo.api.entity.CommonResult;
import com.invo.api.entity.Payment;
import com.invo.payment.service.PaymentService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by INvo
 * on 2020/11/17.
 */
@RestController
@Slf4j
public class PaymentController {
    private static final String LOG_INFO = "INvo For Log Result--";
    private static final String LOG_SERVER_PORT = "INvo For Server Port--";

    @Resource
    private PaymentService paymentService;
    @Resource
    private DiscoveryClient discoveryClient;//服务发现
    @Value("${server.port}")
    private String serverPort;
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.createPayment(payment);
        log.info(LOG_SERVER_PORT+serverPort);
        log.info(LOG_INFO +result);
        if (result > 0) {
            return new CommonResult(200, "Success", result);
        } else {
            return new CommonResult(444, "Failure", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        Payment result = paymentService.getPayment(id);
        log.info(LOG_SERVER_PORT+serverPort);
        log.info(LOG_INFO + result);
        if (null != result) {
            return new CommonResult(200, "Success", result);
        } else {
            return new CommonResult(444, "Failure", null);
        }
    }

    @GetMapping(value = "/payment/get/all")
    public CommonResult getPayment() {
       List<Payment> result= paymentService.getPaymentAll();
        log.info(LOG_SERVER_PORT+serverPort);
        log.info(LOG_INFO + result);
        if (null != result) {
            return new CommonResult(200, "Success"+serverPort, result);
        } else {
            return new CommonResult(444, "Failure", null);
        }
    }
    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info(LOG_INFO + "service:" + service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                log.info(LOG_INFO + "getServiceId:" + instance.getServiceId());
                log.info((LOG_INFO) + "getHost:" + instance.getHost());
                log.info(LOG_INFO + "getPort:" + instance.getPort());
                log.info(LOG_INFO + "getUri:" + instance.getUri());
            }
        }
        return this.discoveryClient;
    }
}
