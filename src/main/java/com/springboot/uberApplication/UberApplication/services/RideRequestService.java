package com.springboot.uberApplication.UberApplication.services;

import com.springboot.uberApplication.UberApplication.entities.RideRequest;

public interface RideRequestService {


    RideRequest findRideRequestById(Long rideRequestId);


    void update(RideRequest rideRequest);

}
