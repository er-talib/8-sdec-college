package com.college.vo;

import java.util.Date;
import java.util.List;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DepartmentVO {
	
	private String depName;
	private String depHeadName;
	private String depStatus;
	private byte totalStaff;
	private Date departmentOpenDate;
	private List<TeacherVO> teacher;
//	private CollegeVO college;

}
