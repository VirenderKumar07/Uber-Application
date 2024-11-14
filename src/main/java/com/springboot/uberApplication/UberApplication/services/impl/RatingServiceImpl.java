package com.springboot.uberApplication.UberApplication.services.impl;

import com.springboot.uberApplication.UberApplication.dto.DriverDto;
import com.springboot.uberApplication.UberApplication.dto.RiderDto;
import com.springboot.uberApplication.UberApplication.entities.Driver;
import com.springboot.uberApplication.UberApplication.entities.Rating;
import com.springboot.uberApplication.UberApplication.entities.Ride;
import com.springboot.uberApplication.UberApplication.entities.Rider;
import com.springboot.uberApplication.UberApplication.exception.ResourceNotFoundException;
import com.springboot.uberApplication.UberApplication.exception.RuntimeConflictException;
import com.springboot.uberApplication.UberApplication.repositories.DriverRepository;
import com.springboot.uberApplication.UberApplication.repositories.RatingRepository;
import com.springboot.uberApplication.UberApplication.repositories.RiderRepository;
import com.springboot.uberApplication.UberApplication.services.RatingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;
    private final DriverRepository driverRepository;
    private final RiderRepository riderRepository;
    private final ModelMapper modelMapper;


    @Override
    public DriverDto rateDriver(Ride ride, Integer rating) {
        Driver driver = ride.getDriver();
        Rating ratingObj = ratingRepository.findByRide(ride).orElseThrow(() -> new ResourceNotFoundException("Rating not found for ride with id:"+ride.getId()));

        if (ratingObj.getDriverRating()!= null)
            throw new RuntimeConflictException("Driver has already has been rated");

        ratingObj.setDriverRating(rating);

        ratingRepository.save(ratingObj);

        Double newRating = ratingRepository.findByDriver(driver)
                .stream()
                .mapToDouble(Rating::getDriverRating)
                .average().orElse(0.0);
        driver.setRating(newRating);

        Driver savedDriver = driverRepository.save(driver);

        return modelMapper.map(savedDriver, DriverDto.class);

    }

    @Override
    public RiderDto rateRider(Ride ride, Integer rating) {
        Rider rider = ride.getRider();
        Rating ratingObj = ratingRepository.findByRide(ride).orElseThrow(() -> new ResourceNotFoundException("Rating not found for ride with id:"+ride.getId()));

        if (ratingObj.getDriverRating()!= null)
            throw new RuntimeConflictException("Rider has already has been rated");


        ratingObj.setRiderRating(rating);

        ratingRepository.save(ratingObj);

        Double newRating = ratingRepository.findByRider(rider)
                .stream()
                .mapToDouble(Rating::getRiderRating)
                .average().orElse(0.0);
        rider.setRating(newRating);

        Rider savedRider = riderRepository.save(rider);
        return modelMapper.map(savedRider, RiderDto.class);
    }

    @Override
    public void createNewRating(Ride ride) {
        Rating rating = Rating.builder()
                .rider(ride.getRider())
                .driver(ride.getDriver())
                .ride(ride)
                .build();
        ratingRepository.save(rating);
    }
}
