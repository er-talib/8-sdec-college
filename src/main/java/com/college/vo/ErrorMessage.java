package com.college.vo;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorMessage {
	
	private HttpStatus status ;
	private String message ;
	private Date timestamp ;

}
