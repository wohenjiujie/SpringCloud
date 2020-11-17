package com.invo.payment.service;

import org.apache.ibatis.annotations.Param;

import com.invo.payment.entity.Payment;

/**
 * Created by INvo
 * on 2020/11/17.
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPayment(@Param("id") Long id);
}
