package com.pranjal.project.uber.uberApplication.strategies;

import com.pranjal.project.uber.uberApplication.dto.RideRequestDto;

public interface RideFareCalStrategy {

	
	double calculationFare(RideRequestDto rideRequestDto);
}
