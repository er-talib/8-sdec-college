package com.college.co;


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
public class CollegeCO {
	
	private String collegeName ;
	private String collegeAddress ;
	private String chairmanName ;
	private String directorName ;
	private FeadBackCO feadback ;	
	private List<DepartmentCO> department ;
	

}
