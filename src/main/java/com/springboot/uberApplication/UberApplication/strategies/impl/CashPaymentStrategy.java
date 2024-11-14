package com.springboot.uberApplication.UberApplication.strategies.impl;

import com.springboot.uberApplication.UberApplication.entities.Driver;
import com.springboot.uberApplication.UberApplication.entities.Payment;
import com.springboot.uberApplication.UberApplication.entities.enums.PaymentStatus;
import com.springboot.uberApplication.UberApplication.entities.enums.TransactionMethod;
import com.springboot.uberApplication.UberApplication.repositories.PaymentRepository;
import com.springboot.uberApplication.UberApplication.services.PaymentService;
import com.springboot.uberApplication.UberApplication.services.WalletService;
import com.springboot.uberApplication.UberApplication.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {

        Driver driver = payment.getRide().getDriver();

        double platformCommission = payment.getAmount() * PLATFORM_COMMISSION;

        walletService.deductMoneyFromWallet(driver.getUser(), platformCommission, null, payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);


    }
}
