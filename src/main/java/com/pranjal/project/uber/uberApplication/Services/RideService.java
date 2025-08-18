package com.pranjal.project.uber.uberApplication.Services;

import com.pranjal.project.uber.uberApplication.Entites.DriverEntity;
import com.pranjal.project.uber.uberApplication.Entites.RideEntity;
import com.pranjal.project.uber.uberApplication.Entites.RideRequestEntity;
import com.pranjal.project.uber.uberApplication.Entites.RideStatus;
import com.pranjal.project.uber.uberApplication.dto.RideRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {

	RideEntity getRideById(Long rideId);
	
	void matchWithDrivers(RideRequestDto rideRequestDto);
	
	RideEntity createNewRide(RideRequestEntity rideRequestEntity, DriverEntity driverEntity);

	
	RideEntity updateRideStatus(RideEntity ride, RideStatus rideStatus);
	
	Page<RideEntity> getAllRidersOfRider(Long rider, PageRequest pageRequest);
	
	Page<RideEntity> getAllRidesOfDriver(Long driverId, PageRequest pageRequest);
	
}
