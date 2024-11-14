package com.springboot.uberApplication.UberApplication.repositories;

import com.springboot.uberApplication.UberApplication.entities.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletTransactionRepository extends JpaRepository<WalletTransaction, Long> {
}
