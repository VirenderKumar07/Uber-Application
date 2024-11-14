package com.springboot.uberApplication.UberApplication.entities;

import com.springboot.uberApplication.UberApplication.entities.enums.PaymentMethod;
import com.springboot.uberApplication.UberApplication.entities.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.nio.file.LinkOption;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @OneToOne(fetch = FetchType.LAZY)
    private Ride ride;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @CreationTimestamp
    private LocalDateTime paymentTime;
}
