package com.college.co;

import java.util.Date;



import com.college.entities.Department;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TeacherCO {
	
	private short teacherId ;
	private String teacherName;
	private String hiredBy;
	private String teacherAddress ;
//	private DepartmentCO department;

}
