package com.springboot.uberApplication.UberApplication.dto;

import com.springboot.uberApplication.UberApplication.entities.Rider;
import com.springboot.uberApplication.UberApplication.entities.enums.PaymentMethod;
import com.springboot.uberApplication.UberApplication.entities.enums.RideRequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideRequestDto {

    private Long id;

    private PointDto pickUpLocation;

    private PointDto dropOffLocation;

    private LocalDateTime requestedTime;

    private RiderDto rider;
    private Double fare;
    private PaymentMethod paymentMethods;

    private RideRequestStatus rideRequestStatus;
}
