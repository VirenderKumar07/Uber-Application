package com.springboot.uberApplication.UberApplication.services;

import com.springboot.uberApplication.UberApplication.entities.Ride;
import com.springboot.uberApplication.UberApplication.entities.User;
import com.springboot.uberApplication.UberApplication.entities.Wallet;
import com.springboot.uberApplication.UberApplication.entities.enums.TransactionMethod;

public interface WalletService {

    Wallet addMoneyToWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod);

    Wallet deductMoneyFromWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod);

    void withdrawAllMyMoneyFromWallet();

    Wallet findWalletById(Long walletId);

    Wallet createNewWallet(User user);

    Wallet findByUser(User user);
}
