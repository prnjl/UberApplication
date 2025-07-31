package com.pranjal.project.uber.uberApplication.ServicesImpl;

import com.pranjal.project.uber.uberApplication.Entites.RiderEntity;
import com.pranjal.project.uber.uberApplication.Entites.UserEntity;
import com.pranjal.project.uber.uberApplication.Enums.Roles;
import com.pranjal.project.uber.uberApplication.Exceptions.RuntimeConflictExceptions;
import com.pranjal.project.uber.uberApplication.Repositories.USerRepository;
import com.pranjal.project.uber.uberApplication.Services.RiderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranjal.project.uber.uberApplication.Services.AuthService;
import com.pranjal.project.uber.uberApplication.dto.DriverDto;
import com.pranjal.project.uber.uberApplication.dto.SignupDto;
import com.pranjal.project.uber.uberApplication.dto.UserDto;

import java.util.Optional;
import java.util.Set;


@Service
public class AuthServiceImpl implements AuthService{


	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private USerRepository uSerRepository  ;

	@Autowired
	private RiderService riderService;
	@Override
	public void login(String email, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserDto signup(SignupDto signUpDto) {

		 UserEntity user=  uSerRepository.findByEmail(signUpDto.getEmail()).orElse(null);

        if (user!=null){
			throw new RuntimeConflictExceptions("Cannot Signup , User Alreday exist with email " + signUpDto.getEmail());

		}

		UserEntity userEntity=modelMapper.map(signUpDto,UserEntity.class);
		userEntity.setRole(Set.of(Roles.RIDER));  //be default anyone try to login we will make him rider

		UserEntity savedUser=  uSerRepository.save(userEntity);

      //create user releted things

		RiderEntity riderEntity = riderService.createNewRider(savedUser);

		// TODO :: Add wallet related service
		return modelMapper.map(savedUser , UserDto.class);
	}

	@Override
	public DriverDto onBoardDriver(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
