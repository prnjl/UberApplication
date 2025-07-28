package com.pranjal.project.uber.uberApplication.Entites;

import java.util.Set;

import com.pranjal.project.uber.uberApplication.Enums.Roles;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "app_user")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String Email;
	private String password;
	@ElementCollection(fetch = FetchType.LAZY)
	@Enumerated(EnumType.STRING)
	private Set<Roles> role;

}
