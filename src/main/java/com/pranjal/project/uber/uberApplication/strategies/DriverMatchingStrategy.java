package com.pranjal.project.uber.uberApplication.strategies;

import com.pranjal.project.uber.uberApplication.Entites.DriverEntity;
import com.pranjal.project.uber.uberApplication.Entites.RideRequestEntity;

import java.util.List;

public interface DriverMatchingStrategy {
	
	
	 List<DriverEntity> findMatchingDriver(RideRequestEntity rideRequestDto);

}
