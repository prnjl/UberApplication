package com.pranjal.project.uber.uberApplication.strategies;

import com.pranjal.project.uber.uberApplication.strategiesImpl.DriverMatchingHigestRatedDriverStrategyImpl;
import com.pranjal.project.uber.uberApplication.strategiesImpl.DriverMatchingNearestDriverStrategyImpl;
import com.pranjal.project.uber.uberApplication.strategiesImpl.RideFAreSurgePricingFAreCalStrategy;
import com.pranjal.project.uber.uberApplication.strategiesImpl.RideFareDefaultCalStrategyImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class RideStrategyManager {


    @Autowired
    private DriverMatchingHigestRatedDriverStrategyImpl driverMatchingHigestRatedDriverStrategy;

    @Autowired
    private DriverMatchingNearestDriverStrategyImpl driverMatchingNearestDriverStrategy;

    private RideFareDefaultCalStrategyImpl rideFareDefaultCalStrategy;

    private RideFAreSurgePricingFAreCalStrategy rideFAreSurgePricingFAreCalStrategy;

    public DriverMatchingStrategy driverMatchingStrategy(Double riderRating) {

        if (riderRating >= 4.8) {
            return driverMatchingHigestRatedDriverStrategy;
        } else {
            return driverMatchingNearestDriverStrategy;
        }

    }

    public RideFareCalStrategy rideFareCalStrategy() {

        //peak hours call surge fare cal strategy   6PM to 10Pm

        LocalTime surgeTimeStart = LocalTime.of(18, 0);
        LocalTime surgeTimeEnd = LocalTime.of(22, 0);
        LocalTime currentTime = LocalTime.now();
        boolean isSurgeTime = currentTime.isAfter(surgeTimeStart) && currentTime.isAfter(surgeTimeEnd);
        if (isSurgeTime) {

            return rideFAreSurgePricingFAreCalStrategy;

        } else {
            return rideFareDefaultCalStrategy;
        }
    }

}
