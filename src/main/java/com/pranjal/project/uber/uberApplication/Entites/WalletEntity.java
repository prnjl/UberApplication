package com.pranjal.project.uber.uberApplication.Entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "app_wallet")
public class WalletEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;

	private Double balance;

	@OneToMany(mappedBy = "wallet", fetch=FetchType.LAZY)
	private List<WalletTransactionEntity> transaction;

}
