package com.springboot.uberApplication.UberApplication.strategies.impl;

import com.springboot.uberApplication.UberApplication.dto.RideRequestDto;
import com.springboot.uberApplication.UberApplication.entities.RideRequest;
import com.springboot.uberApplication.UberApplication.services.DistanceService;
import com.springboot.uberApplication.UberApplication.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {

    private  final DistanceService distanceService;
    private static final double SURGE_FACTOR = 2;

    @Override
    public double calculateFare(RideRequest rideRequest) {
        double distance = distanceService.calculateDistance(rideRequest.getPickUpLocation(),
                rideRequest.getDropOffLocation());
        return distance*RIDE_FARE_MULTIPLIER*SURGE_FACTOR;

    }
}
