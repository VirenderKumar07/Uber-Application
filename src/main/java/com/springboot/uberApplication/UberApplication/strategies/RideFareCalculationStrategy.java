package com.springboot.uberApplication.UberApplication.strategies;

import com.springboot.uberApplication.UberApplication.dto.RideRequestDto;
import com.springboot.uberApplication.UberApplication.entities.RideRequest;

public interface RideFareCalculationStrategy {

     double RIDE_FARE_MULTIPLIER = 10;

    double calculateFare(RideRequest rideRequest);
}
