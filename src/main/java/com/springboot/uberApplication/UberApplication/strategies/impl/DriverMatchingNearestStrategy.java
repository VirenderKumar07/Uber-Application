package com.springboot.uberApplication.UberApplication.strategies.impl;

import com.springboot.uberApplication.UberApplication.entities.Driver;
import com.springboot.uberApplication.UberApplication.entities.RideRequest;
import com.springboot.uberApplication.UberApplication.repositories.DriverRepository;
import com.springboot.uberApplication.UberApplication.strategies.DriverMatchingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverMatchingNearestStrategy implements DriverMatchingStrategy {

    private final DriverRepository driverRepository;

    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return driverRepository.findTenNearestDriver(rideRequest.getPickUpLocation());
    }
}
