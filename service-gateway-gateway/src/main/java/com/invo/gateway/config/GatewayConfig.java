package com.invo.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by INvo
 * on 2020/12/7.
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator getRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder builder=routeLocatorBuilder.routes();
        builder.route("path_test", f -> f.path("/guonei").uri("http://news.baidu.com/guonei"));
        return builder.build();
    }

}
