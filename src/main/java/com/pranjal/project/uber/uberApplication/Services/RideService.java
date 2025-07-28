package com.pranjal.project.uber.uberApplication.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.pranjal.project.uber.uberApplication.Entites.DriverEntity;
import com.pranjal.project.uber.uberApplication.Entites.RideEntity;
import com.pranjal.project.uber.uberApplication.Entites.RideStatus;
import com.pranjal.project.uber.uberApplication.dto.RideRequestDto;

public interface RideService {

	RideEntity getRideById(Long rideId);
	
	void matchWithDrivers(RideRequestDto rideRequestDto);
	
	RideEntity createNewRide(RideRequestDto rideRequestDto, DriverEntity driverEntity);

	
	RideEntity updateRideStatus(Long rideId, RideStatus rideStatus);
	
	Page<RideEntity> getAllRidersOfRider(Long rider, PageRequest pageRequest);
	
	Page<RideEntity> getAllRidesOfDriver(Long driverId, PageRequest pageRequest);
	
}
