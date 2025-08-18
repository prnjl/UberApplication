package com.pranjal.project.uber.uberApplication.strategiesImpl;

import com.pranjal.project.uber.uberApplication.Entites.RideRequestEntity;
import com.pranjal.project.uber.uberApplication.Services.DistanceService;
import com.pranjal.project.uber.uberApplication.strategies.RideFareCalStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RideFareDefaultCalStrategyImpl implements RideFareCalStrategy{
	
	@Autowired
	private DistanceService distanceService;

	@Override
	public double calculationFare(RideRequestEntity rideRequest) {
		// TODO Auto-generated method stub
		
		 double distance =distanceService.calculateDistance(rideRequest.getPickUpLocation(), rideRequest.getDropOffLocation());
		return distance *10;
	}

}
