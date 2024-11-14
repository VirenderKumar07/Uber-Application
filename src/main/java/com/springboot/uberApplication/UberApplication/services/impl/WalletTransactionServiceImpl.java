package com.springboot.uberApplication.UberApplication.services.impl;


import com.springboot.uberApplication.UberApplication.dto.WalletTransactionDto;
import com.springboot.uberApplication.UberApplication.entities.WalletTransaction;
import com.springboot.uberApplication.UberApplication.repositories.WalletTransactionRepository;
import com.springboot.uberApplication.UberApplication.services.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletTransactionServiceImpl implements WalletTransactionService {

    private final WalletTransactionRepository walletTransactionRepository;
    private final ModelMapper modelMapper;

    @Override
    public void createNewWalletTransaction(WalletTransaction walletTransaction) {
      walletTransactionRepository.save(walletTransaction);
    }
}
