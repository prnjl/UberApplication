package com.pranjal.project.uber.uberApplication.ServicesImpl;

import com.pranjal.project.uber.uberApplication.Entites.DriverEntity;
import com.pranjal.project.uber.uberApplication.Entites.RideEntity;
import com.pranjal.project.uber.uberApplication.Entites.RideRequestEntity;
import com.pranjal.project.uber.uberApplication.Entites.RideStatus;
import com.pranjal.project.uber.uberApplication.Enums.RideRequestStatus;
import com.pranjal.project.uber.uberApplication.Exceptions.ResourceNotFoundException;
import com.pranjal.project.uber.uberApplication.Repositories.DriverRepository;
import com.pranjal.project.uber.uberApplication.Services.DriverService;
import com.pranjal.project.uber.uberApplication.Services.RideRequestService;
import com.pranjal.project.uber.uberApplication.Services.RideService;
import com.pranjal.project.uber.uberApplication.dto.DriverDto;
import com.pranjal.project.uber.uberApplication.dto.RideDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private RideRequestService rideRequestService;

    @Autowired
    private RideService rideService;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RideDto accpetRide(Long rideRequestId) {

        RideRequestEntity rideRequestEntity = rideRequestService.findRideRequestById(rideRequestId);

        if (!rideRequestEntity.getRideRequestStatus().equals(RideRequestStatus.PENDING)) {
            throw new RuntimeException("Ride Request cannot be accpeted , status" + rideRequestEntity.getRideRequestStatus());
        }

        DriverEntity currentDriver = getCurrentDriver();
        if (!currentDriver.getIsAvaialble()) {
            throw new RuntimeException("Driver is not available due to unavailability  ");
        }

        /*currentDriver.setIsAvaialble(false);
        DriverEntity savedDriver=driverRepository.save(currentDriver);*/

        DriverEntity savedDriver=updateDriversAvailability(currentDriver,Boolean.FALSE);

        RideEntity createdRide = rideService.createNewRide(rideRequestEntity, savedDriver);


        return modelMapper.map(createdRide, RideDto.class);
    }

    @Override
    public DriverEntity getCurrentDriver() {

        return driverRepository.findById(2L).orElseThrow(() -> new ResourceNotFoundException("driver Not found "));
    }

    @Override
    public RideDto cancelRide(Long rideId) {

        RideEntity ride = rideService.getRideById(rideId);

        DriverEntity driver = getCurrentDriver();

        if (!driver.equals(ride.getDriver())) {
            throw new RuntimeException("Driver cannot cancled  a ride as he has not accpted earlier");
        }
        if(!ride.getRideStatus().equals(RideStatus.CONFIREMED)){
            throw  new RuntimeException("Ride Connot be cancelled , Invalid status "+ride.getRideStatus());
        }
        RideEntity cancledRide= rideService.updateRideStatus(ride,RideStatus.CANCELLED);
        /*driver.setIsAvaialble(true);
        driverRepository.save(driver);*/
        updateDriversAvailability(driver,Boolean.TRUE);
        return modelMapper.map(ride,RideDto.class);
    }

    @Override
    public RideDto startRide(Long rideId, String otp) {

        RideEntity ride = rideService.getRideById(rideId);

        DriverEntity driver = getCurrentDriver();

        if (!driver.equals(ride.getDriver())) {
            throw new RuntimeException("Driver cannot start a ride as he has not accpted earlier");
        }

        if (!ride.getRideStatus().equals(RideStatus.CONFIREMED)) {
            throw new RuntimeException("Ride status is not CONFIRMED Hence cannot be started " + ride.getRideStatus());
        }

        if (!otp.equals(ride.getOtp())) {
            throw new RuntimeException("OTP is invalid");

        }

        ride.setStartedAt(LocalDateTime.now());
        RideEntity savedRide = rideService.updateRideStatus(ride, RideStatus.ONGOING);


        return modelMapper.map(savedRide,RideDto.class);


    }

    @Override
    public RideDto endRide(Long rideId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RideDto rateRider(Long rideId, Integer rating) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DriverDto getMyProfile() {

        DriverEntity driver =getCurrentDriver();
        return  modelMapper.map(driver,DriverDto.class);
        
    }

    @Override
    public DriverEntity updateDriversAvailability(DriverEntity driver, Boolean isAvailable) {

       /* DriverEntity driver=driverRepository.findById(driverId).
                orElseThrow(()->new ResourceNotFoundException("Driver not found with Id "+driverId));
*/

        driver.setIsAvaialble(isAvailable);
      return   driverRepository.save(driver);

    }

    @Override
    public Page<RideDto> getAllMyRides(PageRequest pageRequest) {

        DriverEntity currentDriver = getCurrentDriver();

        Page<RideDto> rideDto= rideService.getAllRidesOfDriver(currentDriver.getId(),pageRequest).map(
                rideEntity -> modelMapper.map(rideEntity,RideDto.class)
        );
        return rideDto;
    }

}
