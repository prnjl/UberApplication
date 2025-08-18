package com.pranjal.project.uber.uberApplication.ServicesImpl;

import com.pranjal.project.uber.uberApplication.Entites.RideRequestEntity;
import com.pranjal.project.uber.uberApplication.Exceptions.ResourceNotFoundException;
import com.pranjal.project.uber.uberApplication.Repositories.RideReqyestRepository;
import com.pranjal.project.uber.uberApplication.Services.RideRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RideRequestServiceImpl implements RideRequestService {


    @Autowired
    private RideReqyestRepository rideReqyestRepository;

    @Override
    public RideRequestEntity findRideRequestById(Long rideRequestId) {

        return  rideReqyestRepository.findById(rideRequestId)
                .orElseThrow(()-> new ResourceNotFoundException("RideRequest not found with "+rideRequestId));

    }

    @Override
    public void updateRideRequest(RideRequestEntity rideRequestEntity) {


        RideRequestEntity toSave= findRideRequestById(rideRequestEntity.getId());

        if(toSave!=null){
            rideReqyestRepository.save(toSave);
        }



    }
}
