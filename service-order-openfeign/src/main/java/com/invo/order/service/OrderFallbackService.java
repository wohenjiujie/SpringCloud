package com.invo.order.service;

import com.invo.api.entity.CommonResult;

/**
 * Created by INvo
 * on 2020/12/1.
 */
public class OrderFallbackService implements OrderService{
    @Override
    public CommonResult getPayment() {
        return null;
    }

    @Override
    public String Test() {
        return null;
    }

    @Override
    public String paymentInfo_OK(Integer id) {
        return "null is ok";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "null is timeout";
    }
}
