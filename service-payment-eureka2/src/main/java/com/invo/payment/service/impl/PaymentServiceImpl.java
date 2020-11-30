package com.invo.payment.service.impl;

import com.invo.api.entity.Payment;
import com.invo.payment.dao.PaymentDao;
import com.invo.payment.service.PaymentService;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

/**
 * Created by INvo
 * on 2020/11/17.
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int createPayment(Payment payment) {
        return paymentDao.createPayment(payment);
    }

    @Override
    public Payment getPayment(Long id) {
        return paymentDao.getPayment(id);
    }

    @Override
    public List<Payment> getPaymentAll() {
        return paymentDao.getPaymentAll();
    }
}
