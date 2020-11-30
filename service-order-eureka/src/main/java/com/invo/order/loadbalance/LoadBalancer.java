package com.invo.order.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * Created by INvo
 * on 2020/11/25.
 */
public interface LoadBalancer {
    ServiceInstance serviceInstance(List<ServiceInstance> serviceInstance);
}
