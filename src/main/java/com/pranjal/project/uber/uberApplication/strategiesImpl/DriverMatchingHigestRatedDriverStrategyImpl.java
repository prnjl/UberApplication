package com.pranjal.project.uber.uberApplication.strategiesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pranjal.project.uber.uberApplication.Entites.DriverEntity;
import com.pranjal.project.uber.uberApplication.dto.RideRequestDto;
import com.pranjal.project.uber.uberApplication.strategies.DriverMatchingStrategy;

@Service
public class DriverMatchingHigestRatedDriverStrategyImpl implements DriverMatchingStrategy {

	@Override
	public List<DriverEntity> findMatchingDriver(RideRequestDto rideRequestDto) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
