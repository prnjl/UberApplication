package com.pranjal.project.uber.uberApplication.dto;

import java.util.Set;

import com.pranjal.project.uber.uberApplication.Enums.Roles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private String name, email;
	private Set<Roles> roles;

}
