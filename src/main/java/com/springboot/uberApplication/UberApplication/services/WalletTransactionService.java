package com.springboot.uberApplication.UberApplication.services;

import com.springboot.uberApplication.UberApplication.dto.WalletTransactionDto;
import com.springboot.uberApplication.UberApplication.entities.WalletTransaction;

public interface WalletTransactionService {

    void createNewWalletTransaction(WalletTransaction walletTransaction);
}
