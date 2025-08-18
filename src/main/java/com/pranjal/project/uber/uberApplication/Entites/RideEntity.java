package com.pranjal.project.uber.uberApplication.Entites;

import com.pranjal.project.uber.uberApplication.Enums.PaymentMenthod;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "app_ride")
public class RideEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "geometry(Point, 4326)")
	private Point pickUpLocation;

	@Column(columnDefinition = "geometry(Point, 4326)")
	private Point dropOffLocation;

	@CreationTimestamp
	private LocalDateTime createdTime;

	@ManyToOne(fetch = FetchType.LAZY)
	private RiderEntity rider;

	@ManyToOne(fetch = FetchType.LAZY)
	private DriverEntity driver;

	@Enumerated(EnumType.STRING)
	private PaymentMenthod paymentMethod;

	@Enumerated(EnumType.STRING)
	private RideStatus rideStatus;

	private String otp;
	
	private Double fare;
	
	private LocalDateTime startedAt;
	private LocalDateTime endedAt;

}
