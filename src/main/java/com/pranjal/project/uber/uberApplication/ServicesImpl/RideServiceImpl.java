package com.pranjal.project.uber.uberApplication.ServicesImpl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.pranjal.project.uber.uberApplication.Entites.DriverEntity;
import com.pranjal.project.uber.uberApplication.Entites.RideEntity;
import com.pranjal.project.uber.uberApplication.Entites.RideStatus;
import com.pranjal.project.uber.uberApplication.Services.RideService;
import com.pranjal.project.uber.uberApplication.dto.RideRequestDto;

public class RideServiceImpl implements RideService {

	@Override
	public RideEntity getRideById(Long rideId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void matchWithDrivers(RideRequestDto rideRequestDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RideEntity createNewRide(RideRequestDto rideRequestDto, DriverEntity driverEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RideEntity updateRideStatus(Long rideId, RideStatus rideStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<RideEntity> getAllRidersOfRider(Long rider, PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<RideEntity> getAllRidesOfDriver(Long driverId, PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
