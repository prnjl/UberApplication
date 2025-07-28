package com.pranjal.project.uber.uberApplication.Entites;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import com.pranjal.project.uber.uberApplication.Enums.PaymentMenthod;
import com.pranjal.project.uber.uberApplication.Enums.RideRequestStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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
	
	private Double fare;
	
	private LocalDateTime startedAt;
	private LocalDateTime endedAt;

}
