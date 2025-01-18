package com.example.authenticationservice.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User extends BaseModel{
	
	private String email;
	private String passwrod;
	 @ManyToMany(cascade = CascadeType.ALL)
	    private List<Role> roles = new ArrayList();
	
 

}
