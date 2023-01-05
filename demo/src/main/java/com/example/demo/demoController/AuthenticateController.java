package com.example.demo.demoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.request.UserRequest;
import com.example.demo.util.JwtUtil;

@RestController
public class AuthenticateController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	 @Autowired
	    private JwtUtil jwtUtil;
	
	@PostMapping("/authenticate")
	public String authenticate(@RequestBody UserRequest userRequest) throws Exception {
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getUserName(), userRequest.getPassword()));
		}catch (Exception e) {
		throw new Exception("Invalid UserName and Password");
		}
		  return jwtUtil.generateToken(userRequest.getUserName());
		}
	
	

}
