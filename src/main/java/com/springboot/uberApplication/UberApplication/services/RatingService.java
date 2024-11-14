package com.springboot.uberApplication.UberApplication.services;

import com.springboot.uberApplication.UberApplication.dto.DriverDto;
import com.springboot.uberApplication.UberApplication.dto.RiderDto;
import com.springboot.uberApplication.UberApplication.entities.Driver;
import com.springboot.uberApplication.UberApplication.entities.Ride;
import com.springboot.uberApplication.UberApplication.entities.Rider;

public interface RatingService {

    DriverDto rateDriver(Ride ride, Integer rating);
    RiderDto rateRider(Ride ride, Integer rating);

    void createNewRating(Ride ride);

}
