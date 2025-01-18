package com.example.authenticationservice.dtos;

import java.util.ArrayList;
import java.util.List;

import com.example.authenticationservice.models.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	private Long id;
	private String email;
	private List<Role> roles = new ArrayList<Role>();

}
