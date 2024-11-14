package com.springboot.uberApplication.UberApplication.services.impl;

import com.springboot.uberApplication.UberApplication.dto.RideDto;
import com.springboot.uberApplication.UberApplication.dto.WalletDto;
import com.springboot.uberApplication.UberApplication.dto.WalletTransactionDto;
import com.springboot.uberApplication.UberApplication.entities.Ride;
import com.springboot.uberApplication.UberApplication.entities.User;
import com.springboot.uberApplication.UberApplication.entities.Wallet;
import com.springboot.uberApplication.UberApplication.entities.WalletTransaction;
import com.springboot.uberApplication.UberApplication.entities.enums.TransactionMethod;
import com.springboot.uberApplication.UberApplication.entities.enums.TransactionType;
import com.springboot.uberApplication.UberApplication.exception.ResourceNotFoundException;
import com.springboot.uberApplication.UberApplication.repositories.WalletRepository;
import com.springboot.uberApplication.UberApplication.services.WalletService;
import com.springboot.uberApplication.UberApplication.services.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;
    private final ModelMapper modelMapper;
    private final WalletTransactionService walletTransactionService;


    @Override
    @Transactional
    public Wallet addMoneyToWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod) {
        Wallet wallet = findByUser(user);
        wallet.setBalance(wallet.getBalance()+amount);

        WalletTransaction walletTransaction = WalletTransaction.builder()
                .transactionId(transactionId)
                .ride(ride)
                .wallet(wallet)
                .transactionType(TransactionType.CREDIT)
                .transactionMethod(transactionMethod)
                .amount(amount)
                .build();

        walletTransactionService.createNewWalletTransaction(walletTransaction);

        return walletRepository.save(wallet);
    }

    @Override
    @Transactional
    public Wallet deductMoneyFromWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod) {
        Wallet wallet = findByUser(user);
        wallet.setBalance(wallet.getBalance()-amount);

        WalletTransaction walletTransaction = WalletTransaction.builder()
                .transactionId(transactionId)
                .ride(ride)
                .wallet(wallet)
                .transactionType(TransactionType.DEBIT)
                .transactionMethod(transactionMethod)
                .amount(amount)
                .build();

        walletTransactionService.createNewWalletTransaction(walletTransaction);


        return walletRepository.save(wallet);
    }

    @Override
    public void withdrawAllMyMoneyFromWallet() {


    }

    @Override
    public Wallet findWalletById(Long walletId) {
        return walletRepository.findById(walletId)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet not found with id:"+walletId));
    }

    @Override
    public Wallet createNewWallet(User user) {
        Wallet wallet = new Wallet();
        wallet.setUser(user);
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet findByUser(User user) {
      return walletRepository.findByUser(user)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet not found for user with id: "+user.getId()));

    }
}
