package com.springboot.uberApplication.UberApplication.strategies.impl;

import com.springboot.uberApplication.UberApplication.entities.RideRequest;
import com.springboot.uberApplication.UberApplication.services.DistanceService;
import com.springboot.uberApplication.UberApplication.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RiderFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {

    private  final DistanceService distanceService;

    @Override
    public double calculateFare(RideRequest rideRequest) {
        double distance = distanceService.calculateDistance(rideRequest.getPickUpLocation(),
                rideRequest.getDropOffLocation());
        return distance*RIDE_FARE_MULTIPLIER;

    }
}
