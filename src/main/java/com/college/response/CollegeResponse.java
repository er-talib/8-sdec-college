package com.college.response;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CollegeResponse {
	
	private String collegeName ;
	private String message ;
	private String status ;

}
