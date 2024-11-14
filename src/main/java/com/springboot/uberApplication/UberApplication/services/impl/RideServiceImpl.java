package com.springboot.uberApplication.UberApplication.services.impl;

import com.springboot.uberApplication.UberApplication.dto.DriverDto;
import com.springboot.uberApplication.UberApplication.dto.RideRequestDto;
import com.springboot.uberApplication.UberApplication.entities.Driver;
import com.springboot.uberApplication.UberApplication.entities.Ride;
import com.springboot.uberApplication.UberApplication.entities.RideRequest;
import com.springboot.uberApplication.UberApplication.entities.Rider;
import com.springboot.uberApplication.UberApplication.entities.enums.RideRequestStatus;
import com.springboot.uberApplication.UberApplication.entities.enums.RideStatus;
import com.springboot.uberApplication.UberApplication.exception.ResourceNotFoundException;
import com.springboot.uberApplication.UberApplication.repositories.RideRepository;
import com.springboot.uberApplication.UberApplication.repositories.RideRequestRepository;
import com.springboot.uberApplication.UberApplication.services.RideRequestService;
import com.springboot.uberApplication.UberApplication.services.RideService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class RideServiceImpl implements RideService {

    private final RideRepository rideRepository;
    private final RideRequestService rideRequestService;
    private final ModelMapper modelMapper;



    @Override
    public Ride getRideById(Long rideId) {
        return rideRepository.findById(rideId)
                .orElseThrow(() ->new ResourceNotFoundException("Ride not found with id "+rideId));
    }


    @Override
    public Ride createNewRide(RideRequest rideRequest, Driver driver) {
        rideRequest.setRideRequestStatus(RideRequestStatus.CONFIRMED);

        Ride ride = modelMapper.map(rideRequest, Ride.class);
        ride.setRideStatus(RideStatus.CONFIRMED);
        ride.setDriver(driver);
        ride.setOtp(generateRandomOTP());
        ride.setId(null);

        rideRequestService.update(rideRequest);
       return rideRepository.save(ride);
    }

    @Override
    public Ride updateRideStatus(Ride ride, RideStatus rideStatus) {
        ride.setRideStatus(rideStatus);
        return rideRepository.save(ride);
    }

    @Override
    public Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest) {

        return rideRepository.findByRider(rider, pageRequest);
    }

    @Override
    public Page<Ride> getAllRidesOfDriver(Driver driver, PageRequest pageRequest) {
        return rideRepository.findByDriver(driver, pageRequest);
    }

    private String generateRandomOTP(){
        Random random = new Random();
       int otpInt = random.nextInt(10000);
       return String.format("%04d", otpInt);

    }

}
