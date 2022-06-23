package com.college.service;

import java.util.List;

import com.college.co.CollegeCO;
import com.college.entities.College;
import com.college.response.AllCollegeResponse;
import com.college.response.CollegeDetailsUpdateResponse;
import com.college.response.CollegeResponse;
import com.college.vo.CollegeVO;


public interface CollegeService {
	
	public CollegeResponse addCollegeDetails(CollegeCO collegeCO);
	public CollegeVO getDetailsByCollegeCode(short collegeCode);
//	public List<CollegeVO> getAllCollegeDetails();
	public CollegeDetailsUpdateResponse updateCollegeDetails(CollegeCO collegeCO, short collegeCode);
	public String deleteCollegeDetailsByCollegeCode( short collegeCode);
	public List<CollegeVO> getAllCollege();
	public List<AllCollegeResponse> getCollegeResponse();

}
