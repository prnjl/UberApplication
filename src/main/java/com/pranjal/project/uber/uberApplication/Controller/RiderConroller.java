package com.pranjal.project.uber.uberApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pranjal.project.uber.uberApplication.Services.RiderService;
import com.pranjal.project.uber.uberApplication.dto.RideRequestDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rider")
@RequiredArgsConstructor
public class RiderConroller {

	
	@Autowired
	private  RiderService riderService;
	
	
	
	@PostMapping("/requestRide")
	public ResponseEntity<RideRequestDto> requestRide(@RequestBody RideRequestDto  rideReuestDto) {
		
		return ResponseEntity.ok(riderService.requestRide(rideReuestDto));
		
	}
}
