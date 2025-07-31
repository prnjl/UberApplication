package com.pranjal.project.uber.uberApplication.strategiesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.pranjal.project.uber.uberApplication.Entites.DriverEntity;
import com.pranjal.project.uber.uberApplication.Entites.RideRequestEntity;
import com.pranjal.project.uber.uberApplication.Repositories.DriverRepository;
import com.pranjal.project.uber.uberApplication.dto.RideRequestDto;
import com.pranjal.project.uber.uberApplication.strategies.DriverMatchingStrategy;


@Service
@Primary
public class DriverMatchingNearestDriverStrategyImpl implements DriverMatchingStrategy {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public List<DriverEntity> findMatchingDriver(RideRequestEntity rideRequest) {
        return driverRepository.findTenNearestDriver(rideRequest.getPickUpLocation());
    }


}
