package com.pranjal.project.uber.uberApplication.ServicesImpl;

import com.pranjal.project.uber.uberApplication.Entites.*;
import com.pranjal.project.uber.uberApplication.Enums.RideRequestStatus;
import com.pranjal.project.uber.uberApplication.Exceptions.ResourceNotFoundException;
import com.pranjal.project.uber.uberApplication.Repositories.RideReqyestRepository;
import com.pranjal.project.uber.uberApplication.Repositories.RiderRepository;
import com.pranjal.project.uber.uberApplication.Services.DriverService;
import com.pranjal.project.uber.uberApplication.Services.RideService;
import com.pranjal.project.uber.uberApplication.Services.RiderService;
import com.pranjal.project.uber.uberApplication.dto.DriverDto;
import com.pranjal.project.uber.uberApplication.dto.RideDto;
import com.pranjal.project.uber.uberApplication.dto.RideRequestDto;
import com.pranjal.project.uber.uberApplication.dto.RiderDto;
import com.pranjal.project.uber.uberApplication.strategies.RideStrategyManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Autowired
    private  DriverService driverService;

    @Autowired
    private RideService rideService;

    //private Logger log = LoggerFactory.getLogger(RiderServiceImpl.class);

    @Override
    @Transactional
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {


        RiderEntity currentRider = getCurrentRider();

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

        RiderEntity currentRider=getCurrentRider();

        RideEntity currentRide=rideService.getRideById(rideId);

        if(!currentRider.equals(currentRide.getRider())){
            throw new RuntimeException("Rider is not allow to cancel the ride with Id:"+rideId);
        }

        if(!currentRide.getRideStatus().equals(RideStatus.CONFIREMED)){
            throw  new RuntimeException("Ride Connot be cancelled , Invalid status "+currentRide.getRideStatus());
        }
        RideEntity canceledRide= rideService.updateRideStatus(currentRide,RideStatus.CANCELLED);

        driverService.updateDriversAvailability(currentRide.getDriver(),Boolean.TRUE);

        return modelMapper.map(canceledRide,RideDto.class);

    }

    @Override
    public DriverDto rateDriver(Long rideId, Integer rating) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RiderDto getMyProfile() {
        // TODO Auto-generated method stub

        RiderEntity  currentRider = getCurrentRider();


        return modelMapper.map(currentRider,RiderDto.class);
    }

    @Override
    public Page<RideDto> getAllMyRides(PageRequest pageRequest) {


        RiderEntity  currentRider = getCurrentRider();

        Page<RideDto> rideDto= rideService.getAllRidersOfRider(currentRider.getId(),pageRequest).map(
                rideEntity -> modelMapper.map(rideEntity,RideDto.class)
        );
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
    public RiderEntity getCurrentRider() {
        //TODO :: implement Spring security to get currentRider
        return riderRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException(
                "Rider Not Found WIth Id" + 1
        ));
    }

}
