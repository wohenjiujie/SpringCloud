package com.invo.payment.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.invo.payment.entity.Payment;

/**
 * Created by INvo
 * on 2020/11/16.
 * 接口类型--增删改查
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPayment(@Param("id") Long id);
}
