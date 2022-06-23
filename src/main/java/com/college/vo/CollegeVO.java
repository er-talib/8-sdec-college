package com.college.vo;

import java.util.Date;
import java.util.List;

import com.college.entities.Department;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CollegeVO {
	
	private String collegeName ;
	private String collegeAddress ;
	private String chairmanName ;
	private String directorName ;
	private Date collegeOpenDate ;
	private FeadbackVO feadback ;	
	private List<DepartmentVO> department ;

}
