package com.springboot.uberApplication.UberApplication.services;

import com.springboot.uberApplication.UberApplication.entities.Payment;
import com.springboot.uberApplication.UberApplication.entities.Ride;
import com.springboot.uberApplication.UberApplication.entities.enums.PaymentStatus;

public interface PaymentService {

    void processPayment(Ride ride);

    Payment createNewPayment(Ride ride);

    void updatePaymentStatus(Payment payment, PaymentStatus status);

}
