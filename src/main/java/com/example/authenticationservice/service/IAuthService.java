package com.example.authenticationservice.service;

import com.example.authenticationservice.exceptions.UserAlreadyExistException;
import com.example.authenticationservice.exceptions.UserNotRegisteredException;
import com.example.authenticationservice.models.User;

public interface IAuthService {
	
	User signUp(String email,String password)throws UserAlreadyExistException;
	User login(String email,String password)throws UserNotRegisteredException;

}
