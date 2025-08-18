package com.pranjal.project.uber.uberApplication.Entites;

import com.pranjal.project.uber.uberApplication.Enums.PaymentMenthod;
import com.pranjal.project.uber.uberApplication.Enums.RideRequestStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Entity
@Table(name="app_ride_req")
@Getter
@Setter
@ToString
public class RideRequestEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "geometry(Point, 4326)")
    private Point pickUpLocation;
	
	@Column(columnDefinition = "geometry(Point, 4326)")
	private Point dropOffLocation;
	
	private Double fare;
	
	@CreationTimestamp
	private LocalDateTime requestedTime;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private RiderEntity rider;
	
	@Enumerated(EnumType.STRING)
	private PaymentMenthod paymentMethod;
	
	@Enumerated(EnumType.STRING)
	private RideRequestStatus rideRequestStatus; 
	
	
}
