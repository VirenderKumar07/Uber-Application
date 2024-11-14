package com.springboot.uberApplication.UberApplication.services.impl;

import com.springboot.uberApplication.UberApplication.dto.DriverDto;
import com.springboot.uberApplication.UberApplication.dto.RideDto;
import com.springboot.uberApplication.UberApplication.dto.RideRequestDto;
import com.springboot.uberApplication.UberApplication.dto.RiderDto;
import com.springboot.uberApplication.UberApplication.entities.*;
import com.springboot.uberApplication.UberApplication.entities.enums.RideRequestStatus;
import com.springboot.uberApplication.UberApplication.entities.enums.RideStatus;
import com.springboot.uberApplication.UberApplication.exception.ResourceNotFoundException;
import com.springboot.uberApplication.UberApplication.repositories.DriverRepository;
import com.springboot.uberApplication.UberApplication.repositories.RideRequestRepository;
import com.springboot.uberApplication.UberApplication.repositories.RiderRepository;
import com.springboot.uberApplication.UberApplication.services.DriverService;
import com.springboot.uberApplication.UberApplication.services.RatingService;
import com.springboot.uberApplication.UberApplication.services.RideService;
import com.springboot.uberApplication.UberApplication.services.RiderService;
import com.springboot.uberApplication.UberApplication.strategies.DriverMatchingStrategy;
import com.springboot.uberApplication.UberApplication.strategies.RideFareCalculationStrategy;
import com.springboot.uberApplication.UberApplication.strategies.RideStrategyManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hibernate.query.sqm.tree.SqmNode.log;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImpl implements RiderService {
    private final DriverRepository driverRepository;

    private final ModelMapper modelMapper;
    private final RideStrategyManager rideStrategyManager;
    private final RideRequestRepository rideRequestRepository;
    private final RiderRepository riderRepository;
    private final RideService rideService;
    private final DriverService driverService;
    private final RatingService ratingService;

    @Override
    @Transactional
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {

        Rider rider = getCurrentRider();
        RideRequest rideRequest = modelMapper.map(rideRequestDto, RideRequest.class);
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
        rideRequest.setRider(rider);


        Double fare= rideStrategyManager.rideFareCalculationStrategy().calculateFare((rideRequest));
        rideRequest.setFare(fare);

        RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);

        List<Driver> drivers = rideStrategyManager
                .driverMatchingStrategy(rider.getRating()).findMatchingDriver(rideRequest);

        return modelMapper.map(savedRideRequest, RideRequestDto.class);
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        Rider rider = getCurrentRider();
        Ride ride = rideService.getRideById(rideId);

        if (!rider.equals(ride.getRider())){
            throw new RuntimeException("Rider does not own thi ride with id: "+rideId);

        }
        if (!ride.getRideStatus().equals(RideStatus.CONFIRMED)){
            throw new RuntimeException("Ride cannot be cancelled, invalid status: "+ride.getRideStatus());
        }

        Ride savedRide = rideService.updateRideStatus(ride, RideStatus.CANCELLED);
       driverService.updateDriverAvailability(ride.getDriver(), true);

         return modelMapper.map(savedRide, RideDto.class);

    }

    @Override
    public DriverDto rateDriver(Long rideId, Integer rating) {
        Ride ride = rideService.getRideById(rideId);
        Rider rider = getCurrentRider();
        if (!rider.equals(ride.getRider())){
            throw new RuntimeException("Driver is not be owner of this ride");
        }
        if (!ride.getRideStatus().equals(RideStatus.ENDED)){
            throw  new RuntimeException("Ride status is not ENDED hence cannot start rating: "+ride.getRideStatus());
        }

        return ratingService.rateDriver(ride, rating);

    }

    @Override
    public RiderDto getMyProfile() {
        Rider currentRider = getCurrentRider();
        return modelMapper.map(currentRider, RiderDto.class);
    }

    @Override
    public Page<RideDto> getAllMyRides(PageRequest pageRequest) {
       Rider currentRider = getCurrentRider();
        return rideService.getAllRidesOfRider(currentRider, pageRequest).map(
                ride -> modelMapper.map(ride, RideDto.class)
        );
    }

    @Override
    public Rider createNewRider(User user) {
        Rider rider = Rider
                .builder()
                .user(user)
                .rating(0.0)
                .build();
        return riderRepository.save(rider);
    }

    @Override
    public Rider getCurrentRider() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return riderRepository.findByUser(user).orElseThrow(() -> new ResourceNotFoundException(
                "Rider not associated with user with id: "+user.getId()
        ));
    }


}