package com.pranjal.project.uber.uberApplication.strategies;

import com.pranjal.project.uber.uberApplication.Entites.RideRequestEntity;

public interface RideFareCalStrategy {

	
	double calculationFare(RideRequestEntity rideRequestDto);
}
