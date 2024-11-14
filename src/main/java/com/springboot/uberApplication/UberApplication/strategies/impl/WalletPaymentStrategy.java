package com.springboot.uberApplication.UberApplication.strategies.impl;

import com.springboot.uberApplication.UberApplication.entities.Driver;
import com.springboot.uberApplication.UberApplication.entities.Payment;
import com.springboot.uberApplication.UberApplication.entities.Rider;
import com.springboot.uberApplication.UberApplication.entities.enums.PaymentStatus;
import com.springboot.uberApplication.UberApplication.entities.enums.TransactionMethod;
import com.springboot.uberApplication.UberApplication.repositories.PaymentRepository;
import com.springboot.uberApplication.UberApplication.services.PaymentService;
import com.springboot.uberApplication.UberApplication.services.WalletService;
import com.springboot.uberApplication.UberApplication.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class WalletPaymentStrategy implements PaymentStrategy {

   private final WalletService walletService;
   private final PaymentRepository paymentRepository;

    @Override
    @Transactional
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();
        Rider rider = payment.getRide().getRider();

        walletService.deductMoneyFromWallet(rider.getUser(),
                payment.getAmount(), null, payment.getRide(), TransactionMethod.RIDE);

        double driverCut = payment.getAmount() * (1 - PLATFORM_COMMISSION);

        walletService.addMoneyToWallet(driver.getUser(),
                driverCut, null, payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);

    }
}
