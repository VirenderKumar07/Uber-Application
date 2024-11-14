package com.springboot.uberApplication.UberApplication.repositories;

import com.springboot.uberApplication.UberApplication.entities.User;
import com.springboot.uberApplication.UberApplication.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findByUser(User user);
}
