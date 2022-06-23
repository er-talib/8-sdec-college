package com.college.response;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;

import lombok.Data;

@Data
public class AllCollegeResponse {

	private short collegeCode;
	private String collegeName;
	private String director;
	private List<DepartmentResponse> departmentResponse;

}
