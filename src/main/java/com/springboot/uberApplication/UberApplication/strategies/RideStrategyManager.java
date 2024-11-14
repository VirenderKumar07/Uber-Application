package com.springboot.uberApplication.UberApplication.strategies;


import com.springboot.uberApplication.UberApplication.strategies.impl.DriverMatchingHighestRatedDriverStrategy;
import com.springboot.uberApplication.UberApplication.strategies.impl.DriverMatchingNearestStrategy;
import com.springboot.uberApplication.UberApplication.strategies.impl.RiderFareDefaultFareCalculationStrategy;
import com.springboot.uberApplication.UberApplication.strategies.impl.RideFareSurgePricingFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {

    private final DriverMatchingHighestRatedDriverStrategy highestRatedDriverStrategy;
    private final DriverMatchingNearestStrategy nearestDriverStrategy;
    private  final RideFareSurgePricingFareCalculationStrategy surgePricingFareCalculationStrategy;
    private final RiderFareDefaultFareCalculationStrategy defaultFareCalculationStrategy;

    public DriverMatchingStrategy driverMatchingStrategy(double riderRating){
        if(riderRating >= 4.8){
            return highestRatedDriverStrategy;

        }else {
            return nearestDriverStrategy;
        }
    }

    public RideFareCalculationStrategy rideFareCalculationStrategy(){

       //6PM to 9PM is surge time
        LocalTime surgeStartTime = LocalTime.of(18, 0);
        LocalTime surgeEndTime = LocalTime.of(21, 0);
        LocalTime currentTime = LocalTime.now();

        boolean isSurgeTime = currentTime.isAfter(surgeStartTime) && currentTime.isBefore((surgeEndTime));

        if(isSurgeTime){
            return surgePricingFareCalculationStrategy;
        }else {
            return defaultFareCalculationStrategy;
        }
    }


}
