package com.pranjal.project.uber.uberApplication.Services;

import com.pranjal.project.uber.uberApplication.Entites.RideRequestEntity;

public interface RideRequestService {

    RideRequestEntity findRideRequestById(Long rideRequestId);

    void updateRideRequest(RideRequestEntity rideRequestEntity);
}
