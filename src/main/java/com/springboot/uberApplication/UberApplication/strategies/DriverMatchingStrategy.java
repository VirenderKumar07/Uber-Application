package com.springboot.uberApplication.UberApplication.strategies;

import com.springboot.uberApplication.UberApplication.dto.RideRequestDto;
import com.springboot.uberApplication.UberApplication.entities.Driver;
import com.springboot.uberApplication.UberApplication.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {

     List<Driver> findMatchingDriver(RideRequest rideRequest);
}
