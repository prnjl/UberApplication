package com.pranjal.project.uber.uberApplication.Entites;

import com.pranjal.project.uber.uberApplication.Enums.PaymentMenthod;
import com.pranjal.project.uber.uberApplication.Enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

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
	
	@OneToMany//(fetch=FetchType.LAZY)
	private List<RideEntity> ride;
	
	private Double amount;
	
	@Enumerated(EnumType.STRING)
	private  PaymentStatus paymentstatus;
	
	@CreationTimestamp
	private LocalDateTime  paymentTime;
	
}
