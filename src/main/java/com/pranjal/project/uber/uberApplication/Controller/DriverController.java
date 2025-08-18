package com.pranjal.project.uber.uberApplication.Controller;


import com.pranjal.project.uber.uberApplication.Services.DriverService;
import com.pranjal.project.uber.uberApplication.dto.RideDto;
import com.pranjal.project.uber.uberApplication.dto.startRideDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("drivers")
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping("/acceptRide/{rideRequestId}")
    public ResponseEntity<RideDto> acceptRide(@PathVariable Long rideRequestId  ){


        return ResponseEntity.ok(driverService.accpetRide(rideRequestId));

    }

    @PostMapping("/startRide/{rideRequestId}")
    public ResponseEntity<RideDto> startRide(@PathVariable Long rideRequestId , @RequestBody startRideDto startRideDto){


        return ResponseEntity.ok(driverService.startRide(rideRequestId,startRideDto.getOtp()));

    }
}
