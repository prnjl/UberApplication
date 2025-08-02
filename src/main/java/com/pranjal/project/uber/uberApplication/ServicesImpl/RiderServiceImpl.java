package com.pranjal.project.uber.uberApplication.ServicesImpl;

import java.util.List;

import com.pranjal.project.uber.uberApplication.Entites.DriverEntity;
import com.pranjal.project.uber.uberApplication.Entites.RiderEntity;
import com.pranjal.project.uber.uberApplication.Entites.UserEntity;
import com.pranjal.project.uber.uberApplication.Exceptions.ResourceNotFoundException;
import com.pranjal.project.uber.uberApplication.Repositories.RiderRepository;
import com.pranjal.project.uber.uberApplication.strategies.RideStrategyManager;
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
import org.springframework.transaction.annotation.Transactional;

@Service

public class RiderServiceImpl implements RiderService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RideStrategyManager rideStrategyManager;

    @Autowired
    private RiderRepository riderRepository;

    @Autowired
    private RideReqyestRepository rideReqyestRepository;

    //private Logger log = LoggerFactory.getLogger(RiderServiceImpl.class);

    @Override
    @Transactional
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {


        RiderEntity currentRider = getCurrentRide();

        RideRequestEntity rideRequest = modelMapper.map(rideRequestDto, RideRequestEntity.class);

        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
        rideRequest.setRider(currentRider);
        //double fare = rideFareCalStrategy.calculationFare(rideRequest);

        double fare = rideStrategyManager.rideFareCalStrategy()
                .calculationFare(rideRequest);


        rideRequest.setFare(fare);

        RideRequestEntity savedRideRequest = rideReqyestRepository.save(rideRequest);

        //driverMatchingStrategy.findMatchingDriver(rideRequest);

      List<DriverEntity> drivers= rideStrategyManager.driverMatchingStrategy(currentRider.getRating()).findMatchingDriver(rideRequest);

      //TODO:: sent notification or Email to all the drivers about this rider soo that they can accept.

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

        RiderEntity riderEntity = RiderEntity.builder()
                .user(savedUser)
                .rating(0.0)
                .build();


        return riderRepository.save(riderEntity);
    }

    @Override
    public RiderEntity getCurrentRide() {
        //TODO :: implement Spring security to get currentRider
        return riderRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException(
                "Rider Not Found WIth Id" + 1
        ));
    }

}
