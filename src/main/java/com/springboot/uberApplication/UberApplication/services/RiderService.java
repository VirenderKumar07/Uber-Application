package com.springboot.uberApplication.UberApplication.services;

import com.springboot.uberApplication.UberApplication.dto.DriverDto;
import com.springboot.uberApplication.UberApplication.dto.RideDto;
import com.springboot.uberApplication.UberApplication.dto.RideRequestDto;
import com.springboot.uberApplication.UberApplication.dto.RiderDto;
import com.springboot.uberApplication.UberApplication.entities.Rider;
import com.springboot.uberApplication.UberApplication.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface RiderService {

    RideRequestDto requestRide(RideRequestDto rideRequestDto);

    RideDto cancelRide(Long rideId);

    DriverDto rateDriver(Long rideId, Integer rating);

    RiderDto getMyProfile();

    Page<RideDto> getAllMyRides(PageRequest pageRequest);

    Rider createNewRider(User user);

    Rider getCurrentRider();
}
