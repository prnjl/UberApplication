package com.pranjal.project.uber.uberApplication.Services;

import java.util.List;

import com.pranjal.project.uber.uberApplication.dto.DriverDto;
import com.pranjal.project.uber.uberApplication.dto.RideDto;

public interface DriverService {


	RideDto accpetRide(Long rideId);
	
	RideDto cancelRide(Long rideId);
	
	RideDto startRide(Long rideId);
	
	RideDto endRide(Long rideId);

	RideDto rateRider(Long rideId, Integer rating);

	DriverDto getMyProfile();
	List<RideDto> getAllMyRides();
}
