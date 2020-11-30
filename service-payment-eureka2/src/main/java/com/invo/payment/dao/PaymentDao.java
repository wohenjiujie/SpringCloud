package com.invo.payment.dao;

import com.invo.api.entity.Payment;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * Created by INvo
 * on 2020/11/16.
 * 接口类型--增删改查
 */
@Mapper
public interface PaymentDao {
     int createPayment(Payment payment);

     Payment getPayment(@Param("id") Long id);

     List<Payment> getPaymentAll();

//     int deletePayment(@Param("id") Long id);
//
//     int updatePayment(@Param("id") Long id);
}
