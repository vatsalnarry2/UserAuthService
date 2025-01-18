package com.example.authenticationservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.authenticationservice.exceptions.UserAlreadyExistException;
import com.example.authenticationservice.exceptions.UserNotRegisteredException;
import com.example.authenticationservice.models.Role;
import com.example.authenticationservice.models.User;
import com.example.authenticationservice.repo.UserRepo;
@Service
public class AuthService implements IAuthService {

	@Autowired
	UserRepo userRepo;
	
	@Override
	public User signUp(String email, String password) throws UserAlreadyExistException {
		
		
		Optional<User>   userOptional = userRepo.findByEmail(email);
		
		if(!userOptional.isEmpty())
		{
			 throw new UserAlreadyExistException("Please try logging ");
		}
		Role role = new Role();
		role.setValue("Customer");
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		
		User user = new User();
		user.setEmail(email);
		user.setPasswrod(password);
		user.setRoles(roles);
		return userRepo.save(user);
		
		
	}

	@Override
	public User login(String email, String password) throws UserNotRegisteredException {
		Optional<User>   userOptional = userRepo.findByEmail(email);
		if(userOptional.isEmpty())
		{
			 throw new UserNotRegisteredException("Please sing up first");
		}
		return userOptional.get();
	}

}
