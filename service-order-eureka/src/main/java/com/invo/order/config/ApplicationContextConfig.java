package com.invo.order.config;

import com.invo.order.loadbalance.LoadBalancer;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by INvo
 * on 2020/11/18.
 */
@Configuration
@Slf4j
public class ApplicationContextConfig {
    @Bean
//    @LoadBalanced  //使用LoadBalanced注解赋予了RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private LoadBalancer loadBalancer;

    /*@Bean
    public URI getMyUri() {
        List<ServiceInstance> instances = discoveryClient.getInstances("COM.INVO.PAYMENT.SERVICE-PAYMENT");
        if (null == instances || 0 >= instances.size()) {
            log.info("****INvo For instances == null");
            return null;
        }
        log.info("****INvo For instances:"+ instances.get(0).getInstanceId()+"\t"+instances.get(0).getUri());
        ServiceInstance serviceInstance = loadBalancer.serviceInstance(instances);
        log.info("****INvo For serviceInstance:"+serviceInstance.getInstanceId()+"\\t"+serviceInstance.getUri());
        URI uri = serviceInstance.getUri();
        log.info("****INvo For URI:"+uri);
        return uri;
    }*/
}
