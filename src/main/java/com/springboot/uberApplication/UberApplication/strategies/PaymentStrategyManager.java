package com.springboot.uberApplication.UberApplication.strategies;

import com.springboot.uberApplication.UberApplication.entities.enums.PaymentMethod;
import com.springboot.uberApplication.UberApplication.strategies.impl.CashPaymentStrategy;
import com.springboot.uberApplication.UberApplication.strategies.impl.WalletPaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentStrategyManager {

    private final WalletPaymentStrategy walletPaymentStrategy;
    private final CashPaymentStrategy cashPaymentStrategy;


    public PaymentStrategy paymentStrategy(PaymentMethod paymentMethod){
        return switch (paymentMethod){
            case WALLET -> walletPaymentStrategy;
            case CASH -> cashPaymentStrategy;
        };
    }
}
