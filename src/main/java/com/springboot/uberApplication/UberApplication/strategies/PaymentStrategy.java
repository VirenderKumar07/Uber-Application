package com.springboot.uberApplication.UberApplication.strategies;

import com.springboot.uberApplication.UberApplication.entities.Payment;

public interface PaymentStrategy {

     Double PLATFORM_COMMISSION = 0.3;

    void processPayment(Payment payment);
}
