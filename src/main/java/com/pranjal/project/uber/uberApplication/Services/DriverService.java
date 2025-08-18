package com.pranjal.project.uber.uberApplication.Services;

import com.pranjal.project.uber.uberApplication.Entites.DriverEntity;
import com.pranjal.project.uber.uberApplication.dto.DriverDto;
import com.pranjal.project.uber.uberApplication.dto.RideDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface DriverService {


	RideDto accpetRide(Long rideRequestId);

	public DriverEntity getCurrentDriver();

	RideDto cancelRide(Long rideId);

	RideDto startRide(Long rideId, String otp);

	RideDto endRide(Long rideId);

	RideDto rateRider(Long rideId, Integer rating);

	DriverDto getMyProfile();

  DriverEntity updateDriversAvailability(DriverEntity driver, Boolean isAvailable);
	Page<RideDto> getAllMyRides(PageRequest pageRequest);
}
