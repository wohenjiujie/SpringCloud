package com.invo.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by INvo
 * on 2020/11/25.
 */
@Configuration
public class RibbonRule {
    /**
     * Define method of loadBalance
     * @return
     */
    @Bean
    public IRule myRule(){
//        return new RoundRobinRule();
        return new RandomRule();
    }
}
