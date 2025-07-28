package com.pranjal.project.uber.uberApplication.Services;

import com.pranjal.project.uber.uberApplication.dto.DriverDto;
import com.pranjal.project.uber.uberApplication.dto.SignupDto;
import com.pranjal.project.uber.uberApplication.dto.UserDto;

public interface AuthService {
	
	void login(String email,String password);
	UserDto signup(SignupDto signUpDto);
	
	DriverDto onBoardDriver(Long userId );

}
