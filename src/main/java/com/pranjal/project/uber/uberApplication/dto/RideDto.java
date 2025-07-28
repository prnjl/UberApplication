package com.pranjal.project.uber.uberApplication.dto;

import java.time.LocalDateTime;

import org.locationtech.jts.geom.Point;

import com.pranjal.project.uber.uberApplication.Entites.RideStatus;
import com.pranjal.project.uber.uberApplication.Enums.PaymentMenthod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideDto {

	private Long id;

	private Point pickUpLocation;

	private Point dropOffLocation;

	private LocalDateTime createdTime;

	private RiderDto rider;

	private DriverDto driver;

	private PaymentMenthod paymentMethod;

	private RideStatus rideStatus;

	private Double fare;

	private LocalDateTime startedAt;
	private LocalDateTime endedAt;
}
