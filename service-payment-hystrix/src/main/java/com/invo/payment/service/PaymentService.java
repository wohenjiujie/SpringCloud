package com.invo.payment.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.springframework.stereotype.Service;

/**
 * Created by INvo
 * on 2020/11/27.
 */
@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id) {
        return "Thead Pool:" + Thread.currentThread().getName() + "paymentInfo_OK,id:" + id + "\t" + "Good";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String paymentInfo_Timeout(Integer id) {
//        int timeNum = 5;
        int error = 10 / 0;
       /* try {
            TimeUnit.SECONDS.sleep(timeNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return "Thead Pool:" + Thread.currentThread().getName() + "paymentInfo_OK,id:" + id + "\t" + "Bad request";
    }

    public String paymentInfo_TimeoutHandler(Integer id) {
        return "Thead Pool:" + Thread.currentThread().getName() + "paymentInfo_OK,id:" + id + "\t" + "TimeoutHandler Is Start";
    }
}
