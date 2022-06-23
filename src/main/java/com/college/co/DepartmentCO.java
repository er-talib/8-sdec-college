package com.college.co;

import java.sql.Date;
import java.util.List;



import com.college.entities.College;
import com.college.entities.Teacher;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DepartmentCO {
	
	private short depCode ;
	private String depName;
	private String depHeadName;
	private String depStatus;
	private byte totalStaff;
	private List<TeacherCO> teacher;
//	private CollegeCO college;

}
