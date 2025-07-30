package com.pranjal.project.uber.uberApplication.Entites;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.pranjal.project.uber.uberApplication.Enums.TransactionMethod;
import com.pranjal.project.uber.uberApplication.Enums.TransactionType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "app_wallet_Transc")
public class WalletTransactionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double amount;

	private TransactionType transactionType;

	private TransactionMethod transactionMethod;
	
	@OneToOne
	private RideEntity ride;
	
	private String transactionId;
	
	@ManyToOne
	private WalletEntity wallet;
	
	@CreationTimestamp
	private LocalDateTime timeStamp;
}
