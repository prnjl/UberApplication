package com.pranjal.project.uber.uberApplication.dto;

import com.pranjal.project.uber.uberApplication.Enums.PaymentMenthod;
import com.pranjal.project.uber.uberApplication.Enums.RideRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideRequestDto {
	private Long id;

	private PointDto pickUpLocation;

	private PointDto  dropOffLocation;

	private LocalDateTime requestedTime;

	private RiderDto rider;
	private Double fare;

	private PaymentMenthod paymentMethod;

	private RideRequestStatus rideRequestStatus;
}
