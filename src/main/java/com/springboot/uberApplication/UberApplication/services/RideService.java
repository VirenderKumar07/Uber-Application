package com.springboot.uberApplication.UberApplication.services;

import com.springboot.uberApplication.UberApplication.dto.RideRequestDto;
import com.springboot.uberApplication.UberApplication.entities.Driver;
import com.springboot.uberApplication.UberApplication.entities.Ride;
import com.springboot.uberApplication.UberApplication.entities.RideRequest;
import com.springboot.uberApplication.UberApplication.entities.Rider;
import com.springboot.uberApplication.UberApplication.entities.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {

    Ride getRideById(Long rideId);

    Ride createNewRide(RideRequest rideRequest, Driver driver);

    Ride updateRideStatus(Ride ride, RideStatus rideStatus);

    Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest);

    Page<Ride> getAllRidesOfDriver(Driver driver, PageRequest pageRequest);

}
