package com.pranjal.project.uber.uberApplication.ServicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pranjal.project.uber.uberApplication.Services.RiderService;
import com.pranjal.project.uber.uberApplication.dto.DriverDto;
import com.pranjal.project.uber.uberApplication.dto.RideDto;
import com.pranjal.project.uber.uberApplication.dto.RideRequestDto;
import com.pranjal.project.uber.uberApplication.dto.RiderDto;


@Service
public class RiderServiceImpl implements RiderService{

	@Override
	public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RideDto cancelRide(Long rideId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverDto rateDriver(Long rideId, Integer rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RiderDto getMyProfile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RideDto> getAllMyRides() {
		// TODO Auto-generated method stub
		return null;
	}

}
