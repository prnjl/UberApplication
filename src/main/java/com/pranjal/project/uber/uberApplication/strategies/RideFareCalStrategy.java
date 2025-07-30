package com.pranjal.project.uber.uberApplication.strategies;

import com.pranjal.project.uber.uberApplication.Entites.RideRequestEntity;
import com.pranjal.project.uber.uberApplication.dto.RideRequestDto;

public interface RideFareCalStrategy {

	
	double calculationFare(RideRequestEntity rideRequestDto);
}
