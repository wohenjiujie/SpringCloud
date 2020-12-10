package com.invo.gateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;

import java.util.Date;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * Created by INvo
 * on 2020/12/8.
 */

@Configuration
@Slf4j
public class GateWayFilterConfig implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("*****INvo for log in:" + new Date());
        String userName = exchange.getRequest().getQueryParams().getFirst("userName");
        if (null == userName) {
            log.info("*****INvo for log in status is null !!!!!" );
            exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
