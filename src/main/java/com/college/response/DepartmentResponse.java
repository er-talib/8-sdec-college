package com.college.response;

import java.util.List;

import lombok.Data;

@Data
public class DepartmentResponse {

	private short depCode;
	private String departmetName;
	private String status;
	private List<TeacherResponse> teacherResponse;

}
