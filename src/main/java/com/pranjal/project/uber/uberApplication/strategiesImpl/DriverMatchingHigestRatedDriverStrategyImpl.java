package com.pranjal.project.uber.uberApplication.strategiesImpl;

import com.pranjal.project.uber.uberApplication.Entites.DriverEntity;
import com.pranjal.project.uber.uberApplication.Entites.RideRequestEntity;
import com.pranjal.project.uber.uberApplication.Repositories.DriverRepository;
import com.pranjal.project.uber.uberApplication.strategies.DriverMatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverMatchingHigestRatedDriverStrategyImpl implements DriverMatchingStrategy {

    @Autowired
    private DriverRepository driverRepository;


    @Override
    public List<DriverEntity> findMatchingDriver(RideRequestEntity rideRequestDto) {
        // TODO Auto-generated method stub
        return driverRepository.findNearByTopRetedDrivers(rideRequestDto.getPickUpLocation());
    }


}
