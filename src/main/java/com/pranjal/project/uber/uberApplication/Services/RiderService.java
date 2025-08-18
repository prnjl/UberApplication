package com.pranjal.project.uber.uberApplication.Services;

import com.pranjal.project.uber.uberApplication.Entites.RiderEntity;
import com.pranjal.project.uber.uberApplication.Entites.UserEntity;
import com.pranjal.project.uber.uberApplication.dto.DriverDto;
import com.pranjal.project.uber.uberApplication.dto.RideDto;
import com.pranjal.project.uber.uberApplication.dto.RideRequestDto;
import com.pranjal.project.uber.uberApplication.dto.RiderDto;

import java.util.List;

public interface RiderService {

	RideRequestDto requestRide(RideRequestDto rideRequestDto);

	RideDto cancelRide(Long rideId);

	DriverDto rateDriver(Long rideId, Integer rating);

	RiderDto getMyProfile();

	List<RideDto> getAllMyRides();

	RiderEntity createNewRider(UserEntity savedUser);

	RiderEntity getCurrentRider();

}
