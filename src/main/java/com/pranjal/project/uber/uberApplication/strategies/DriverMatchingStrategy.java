package com.pranjal.project.uber.uberApplication.strategies;

import java.util.List;

import com.pranjal.project.uber.uberApplication.Entites.DriverEntity;
import com.pranjal.project.uber.uberApplication.Entites.RideRequestEntity;

public interface DriverMatchingStrategy {
	
	
	 List<DriverEntity> findMatchingDriver(RideRequestEntity rideRequestDto);

}
