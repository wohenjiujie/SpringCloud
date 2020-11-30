package com.invo.order.controller;


import com.invo.api.entity.CommonResult;
import com.invo.api.entity.Payment;
import com.invo.order.loadbalance.LoadBalancer;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

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
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

//    @Resource
//    private URI uri;

    @GetMapping("/consumer/order/create")
    public CommonResult<Payment> create(Payment payment) {

        return restTemplate.postForObject(getUri() + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/order/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(getUri() + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/order/get/all")
    public CommonResult<Payment> getPayment() {
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(getUri() + "/payment/get/all", CommonResult.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            return new CommonResult<>(444, "Failure");
        }
    }

    @GetMapping("/consumer/order/discovery")
    public String getPaymentDiscovery() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(getUri() + "/payment/discovery", String.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            return new CommonResult<>(444, "Failure").toString();
        }
    }

    @GetMapping(value = "/consumer/order/loadBalance")
    public String getPaymentLoadBalance() {
        return restTemplate.getForObject(getUri() + "/payment/loadBalance", String.class);
    }

    private URI getUri() {
        List<ServiceInstance> instances = discoveryClient.getInstances("COM.INVO.PAYMENT.SERVICE-PAYMENT");
        if (null == instances || 0 >= instances.size()) {
            log.info("****INvo For instances == null");
            return null;
        }
        log.info("****INvo For instances:" + instances.get(0).getInstanceId() + "\t" + instances.get(0).getUri());
        ServiceInstance serviceInstance = loadBalancer.serviceInstance(instances);
        log.info("****INvo For serviceInstance:" + serviceInstance.getInstanceId() + "\\t" + serviceInstance.getUri());
        URI uri = serviceInstance.getUri();
        log.info("****INvo For URI:" + uri);
        return serviceInstance.getUri();
    }
}
