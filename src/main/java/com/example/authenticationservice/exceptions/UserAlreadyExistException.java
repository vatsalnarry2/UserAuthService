package com.example.authenticationservice.exceptions;

public class UserAlreadyExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3391295077238101748L;
	 public UserAlreadyExistException(String message) {
	        super(message);
	    }

}
