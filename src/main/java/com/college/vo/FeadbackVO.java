package com.college.vo;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FeadbackVO {
	
	private String collegeName ;
	private String feadBack ;
	private Date feadBackDate ;

}
