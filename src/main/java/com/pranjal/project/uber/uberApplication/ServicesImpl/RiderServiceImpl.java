package com.pranjal.project.uber.uberApplication.ServicesImpl;

import java.util.List;

import com.pranjal.project.uber.uberApplication.Entites.RiderEntity;
import com.pranjal.project.uber.uberApplication.Entites.UserEntity;
import com.pranjal.project.uber.uberApplication.Repositories.RiderRepository;
import lombok.Builder;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranjal.project.uber.uberApplication.Entites.RideRequestEntity;
import com.pranjal.project.uber.uberApplication.Enums.RideRequestStatus;
import com.pranjal.project.uber.uberApplication.Repositories.RideReqyestRepository;
import com.pranjal.project.uber.uberApplication.Services.RiderService;
import com.pranjal.project.uber.uberApplication.dto.DriverDto;
import com.pranjal.project.uber.uberApplication.dto.RideDto;
import com.pranjal.project.uber.uberApplication.dto.RideRequestDto;
import com.pranjal.project.uber.uberApplication.dto.RiderDto;
import com.pranjal.project.uber.uberApplication.strategies.DriverMatchingStrategy;
import com.pranjal.project.uber.uberApplication.strategies.RideFareCalStrategy;

import lombok.extern.slf4j.Slf4j;

@Service

public class RiderServiceImpl implements RiderService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RiderRepository riderRepository;
	@Autowired
	private RideFareCalStrategy rideFareCalStrategy;

	@Autowired
	private RideReqyestRepository rideReqyestRepository;

	@Autowired
	private DriverMatchingStrategy driverMatchingStrategy;
	//private Logger log = LoggerFactory.getLogger(RiderServiceImpl.class);

	@Override
	public RideRequestDto requestRide(RideRequestDto rideRequestDto) {

		RideRequestEntity rideRequest = modelMapper.map(rideRequestDto, RideRequestEntity.class);

		rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);

		double fare = rideFareCalStrategy.calculationFare(rideRequest);
		rideRequest.setFare(fare);

		RideRequestEntity savedRideRequest = rideReqyestRepository.save(rideRequest);

		driverMatchingStrategy.findMatchingDriver(rideRequest);

		
		return modelMapper.map(savedRideRequest, RideRequestDto.class);
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

	@Override
	public RiderEntity createNewRider(UserEntity savedUser) {

		RiderEntity riderEntity= RiderEntity.builder()
				.user(savedUser)
				.rating(0.0)
				.build();


		return riderRepository.save(riderEntity);
	}

}
