package com.invo.payment.service;

import com.invo.api.entity.Payment;

import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * Created by INvo
 * on 2020/11/17.
 */
public interface PaymentService {
    int createPayment(Payment payment);

    Payment getPayment(@Param("id") Long id);

    List<Payment> getPaymentAll();
}
