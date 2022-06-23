package com.college.vo;

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
public class TeacherVO {

	private String teacherName;
	private String hiredBy;
	private String teacherAddress;
	private Date teacherJoiningDate;
	private Date teacherQuitDate;
//	private DepartmentVO department;

}
