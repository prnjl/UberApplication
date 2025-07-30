package com.pranjal.project.uber.uberApplication.Entites;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.pranjal.project.uber.uberApplication.Enums.PaymentMenthod;
import com.pranjal.project.uber.uberApplication.Enums.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "app_payment")
public class PaymentEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private PaymentMenthod paymentMenthod;
	
	@OneToMany(fetch=FetchType.LAZY)
	private RideEntity ride;
	
	private Double amount;
	
	@Enumerated(EnumType.STRING)
	private  PaymentStatus paymentstatus;
	
	@CreationTimestamp
	private LocalDateTime  paymentTime;
	
}
