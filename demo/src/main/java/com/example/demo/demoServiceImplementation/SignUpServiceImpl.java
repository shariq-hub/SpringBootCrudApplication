package com.example.demo.demoServiceImplementation;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.DemoEntity.UserEntity;
import com.example.demo.demoRepo.UserRepo;
import com.example.demo.demoService.SignUpService;
import com.example.demo.request.UserRequest;

import ch.qos.logback.classic.Logger;
import lombok.extern.java.Log;

@Service
public class SignUpServiceImpl implements SignUpService{
	
	@Autowired
	UserRepo userRepo;

//	@Autowired
//	ModelMapper modelMapper;
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public String signUp(UserRequest userRequest) {
		UserEntity userEntity=new UserEntity();
		userEntity.setUsername(userRequest.getUserName());
		String encodedPassword=bCryptPasswordEncoder.encode(userRequest.getPassword());
		userEntity.setPassword(encodedPassword);
		UserEntity saveUser=null;
		Optional<UserEntity> findByUsername = userRepo.findByUsername(userRequest.getUserName());
	
		if(findByUsername.isPresent()) {
			 saveUser = findByUsername.get();
			 return new String("User Already Exist");
			 
		}
		
		
		else {
			
		userRepo.save(userEntity);
		return new String("User Created Successfully!");
		}
		
	}

}
