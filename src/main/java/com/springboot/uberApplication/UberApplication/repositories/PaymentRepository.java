package com.springboot.uberApplication.UberApplication.repositories;

import com.springboot.uberApplication.UberApplication.entities.Payment;
import com.springboot.uberApplication.UberApplication.entities.Ride;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    
    Optional<Payment> findByRide(Ride ride);
}
