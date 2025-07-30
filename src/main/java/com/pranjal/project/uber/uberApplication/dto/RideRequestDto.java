package com.pranjal.project.uber.uberApplication.dto;

import java.time.LocalDateTime;

import org.locationtech.jts.geom.Point;

import com.pranjal.project.uber.uberApplication.Enums.PaymentMenthod;
import com.pranjal.project.uber.uberApplication.Enums.RideRequestStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideRequestDto {
	private Long id;

	private PointDto pickUpLocation;

	private PointDto  dropOffLocation;

	private LocalDateTime requestedTime;

	private RiderDto rider;

	private PaymentMenthod paymentMethod;

	private RideRequestStatus rideRequestStatus;
}
