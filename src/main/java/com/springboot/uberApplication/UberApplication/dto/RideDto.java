package com.springboot.uberApplication.UberApplication.dto;

import com.springboot.uberApplication.UberApplication.entities.Driver;
import com.springboot.uberApplication.UberApplication.entities.Rider;
import com.springboot.uberApplication.UberApplication.entities.enums.PaymentMethod;
import com.springboot.uberApplication.UberApplication.entities.enums.RideStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;

@Data
public class RideDto {

    private Long id;
    private PointDto pickUpLocation;
    private PointDto dropOffLocation;
    private LocalDateTime createdTime;
    private RiderDto rider;

    private DriverDto driver;
    private PaymentMethod paymentMethod;

    private RideStatus rideStatus;
    private String otp;

    private Double fare;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
}
