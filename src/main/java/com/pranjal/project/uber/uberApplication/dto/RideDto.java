package com.pranjal.project.uber.uberApplication.dto;

import com.pranjal.project.uber.uberApplication.Entites.RideStatus;
import com.pranjal.project.uber.uberApplication.Enums.PaymentMenthod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideDto {

	private Long id;

	private PointDto pickUpLocation;

	private PointDto dropOffLocation;

	private LocalDateTime createdTime;

	private RiderDto rider;

	private DriverDto driver;

	private PaymentMenthod paymentMethod;

	private RideStatus rideStatus;

	private Double fare;

	private LocalDateTime startedAt;
	private LocalDateTime endedAt;
}
