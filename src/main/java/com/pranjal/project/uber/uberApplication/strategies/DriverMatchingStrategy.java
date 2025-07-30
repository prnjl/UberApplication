package com.pranjal.project.uber.uberApplication.strategies;

import java.util.List;

import com.pranjal.project.uber.uberApplication.Entites.DriverEntity;
import com.pranjal.project.uber.uberApplication.dto.RideRequestDto;

public interface DriverMatchingStrategy {
	
	
	 List<DriverEntity> findMatchingDriver(RideRequestDto rideRequestDto);

}
