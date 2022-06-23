package com.college.exception;

public class CollegeDetailsNotFound extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public CollegeDetailsNotFound() {
		
	}
	
	public CollegeDetailsNotFound(String message) {
	  super(message);
	}
	
   
}
