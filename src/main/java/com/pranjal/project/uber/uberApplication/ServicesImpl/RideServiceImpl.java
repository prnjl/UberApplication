package com.pranjal.project.uber.uberApplication.ServicesImpl;

import com.pranjal.project.uber.uberApplication.Entites.DriverEntity;
import com.pranjal.project.uber.uberApplication.Entites.RideEntity;
import com.pranjal.project.uber.uberApplication.Entites.RideRequestEntity;
import com.pranjal.project.uber.uberApplication.Entites.RideStatus;
import com.pranjal.project.uber.uberApplication.Enums.RideRequestStatus;
import com.pranjal.project.uber.uberApplication.Exceptions.ResourceNotFoundException;
import com.pranjal.project.uber.uberApplication.Repositories.RideRepository;
import com.pranjal.project.uber.uberApplication.Services.RideRequestService;
import com.pranjal.project.uber.uberApplication.Services.RideService;
import com.pranjal.project.uber.uberApplication.dto.RideRequestDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RideServiceImpl implements RideService {


	@Autowired
	private RideRepository rideRepository;

	@Autowired
	private RideRequestService rideRequestService;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public RideEntity getRideById(Long rideId) {
		// TODO Auto-generated method stub
		return rideRepository.findById(rideId).orElseThrow(()->new ResourceNotFoundException("Ride not Found with id "+rideId));
	}

	@Override
	public void matchWithDrivers(RideRequestDto rideRequestDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RideEntity createNewRide(RideRequestEntity rideRequestEntity, DriverEntity driverEntity) {
		// TODO Auto-generated method stub

		rideRequestEntity.setRideRequestStatus(RideRequestStatus.CONFIRMED);
		rideRequestService.updateRideRequest(rideRequestEntity);

		RideEntity ride=modelMapper.map(rideRequestEntity, RideEntity.class);

		ride.setRideStatus(RideStatus.CONFIREMED);

		ride.setDriver(driverEntity);

		ride.setOtp(generateRandomOtp());
		ride.setId(null);

		return rideRepository.save(ride);

	}

	@Override
	public RideEntity updateRideStatus(RideEntity ride, RideStatus rideStatus) {


		ride.setRideStatus(rideStatus);
      RideEntity savedRide=rideRepository.save(ride);
		return savedRide;
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


	private String generateRandomOtp(){

		Random random= new Random();
		int otp =random.nextInt(10000); //0 to 9999

		return String.format("%04d",otp);
	}
}
