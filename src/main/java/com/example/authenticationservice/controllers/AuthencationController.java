package com.example.authenticationservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.authenticationservice.dtos.LoginRequest;
import com.example.authenticationservice.dtos.SignUpRequest;
import com.example.authenticationservice.dtos.UserDto;
import com.example.authenticationservice.exceptions.UserAlreadyExistException;
import com.example.authenticationservice.exceptions.UserNotRegisteredException;
import com.example.authenticationservice.models.User;
import com.example.authenticationservice.service.IAuthService;

@RestController
@RequestMapping("/auth")
public class AuthencationController {
	
	@Autowired
	IAuthService authService;
	
	   @PostMapping("/signup")
	public ResponseEntity<UserDto> singUp(@RequestBody SignUpRequest signUpRequest)
	{
		try {
			User user =authService.signUp(signUpRequest.getEmail(), signUpRequest.getPassword());
			return new ResponseEntity<>(from(user),HttpStatus.CREATED);
			
		} catch (UserAlreadyExistException e) {
			 return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		}
	
	private UserDto from(User user) {
		UserDto userDto= new UserDto();
		userDto.setEmail(user.getEmail());
		userDto.setRoles(user.getRoles());
		
		return userDto;
	}

	@PostMapping("/login")
	public ResponseEntity<UserDto> login(@RequestBody LoginRequest loginRequest)
	{
		try {
			
			User user =authService.login(loginRequest.getEmail(), loginRequest.getPassword());
			return new ResponseEntity<>(from(user),HttpStatus.OK);
		} catch (UserNotRegisteredException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

}
