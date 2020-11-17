package com.invo.payment.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.invo.payment.dao.PaymentDao;
import com.invo.payment.entity.Payment;
import com.invo.payment.service.PaymentService;

/**
 * Created by INvo
 * on 2020/11/17.
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPayment(Long id) {
        return paymentDao.getPayment(id);
    }
}
