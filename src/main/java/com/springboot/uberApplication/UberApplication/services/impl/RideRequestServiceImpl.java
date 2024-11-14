package com.springboot.uberApplication.UberApplication.services.impl;

import com.springboot.uberApplication.UberApplication.entities.RideRequest;
import com.springboot.uberApplication.UberApplication.exception.ResourceNotFoundException;
import com.springboot.uberApplication.UberApplication.repositories.RideRequestRepository;
import com.springboot.uberApplication.UberApplication.services.RideRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RideRequestServiceImpl implements RideRequestService {

    private final RideRequestRepository rideRequestRepository;

    @Override
    public RideRequest findRideRequestById(Long rideRequestId) {
        return rideRequestRepository.findById(rideRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("RideRequest not found with id: "+rideRequestId));
    }

    @Override
    public void update(RideRequest rideRequest) {
        rideRequestRepository.findById(rideRequest.getId())
                .orElseThrow(() -> new ResourceNotFoundException("RideRequest not found with id: "+rideRequest.getId()));
        rideRequestRepository.save(rideRequest);

    }

}
