package com.college.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.co.CollegeCO;
import com.college.entities.College;
import com.college.repositories.CollegeRepository;
import com.college.response.AllCollegeResponse;
import com.college.response.CollegeDetailsUpdateResponse;
import com.college.response.CollegeResponse;
import com.college.service.CollegeService;
import com.college.service.impl.CollegeServiceImpl;
import com.college.vo.CollegeVO;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/college/details")
@RequiredArgsConstructor
public class CollegeController {

	
	private final CollegeService collegeService;
	private final CollegeRepository collegeRepository;

	
	
	@PostMapping(value = "/add", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> addCollegeDetails(@RequestBody CollegeCO collegeCO) {
		CollegeResponse collegeDetails = this.collegeService.addCollegeDetails(collegeCO);
		return new ResponseEntity(collegeDetails, HttpStatus.CREATED);
	}

	@GetMapping(value = "/get/{collegeCode}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> getDetailsByCollegeCode(@PathVariable short collegeCode) {
		
		CollegeVO collegeVODetails = this.collegeService.getDetailsByCollegeCode(collegeCode);

//		Optional<College> college = this.collegeRepository.findById(collegeCode);
//		College college2 = college.get();

//		if (college2.getCollegeCode() == collegeCode) {
			return ResponseEntity.ok(collegeVODetails);
			
//		}
		
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PutMapping("/update/{collegeCode}")
	public ResponseEntity<?> updateCollegeDetails(@PathVariable short collegeCode, @RequestBody CollegeCO collegeCO) {

		Optional<College> collegeDetails = this.collegeRepository.findById(collegeCode);
		if (collegeDetails.isPresent()) {
			CollegeDetailsUpdateResponse updateCollegeDetails = this.collegeService.updateCollegeDetails(collegeCO,
					collegeCode);
			return ResponseEntity.status(HttpStatus.OK).body(updateCollegeDetails);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@DeleteMapping("/remove/{collegeCode}")
	public ResponseEntity<String> deleteDetailsByCollegeCode(@PathVariable short collegeCode) {
		String detailsByCollegeCode = this.collegeService.deleteCollegeDetailsByCollegeCode(collegeCode);
		return ResponseEntity.ok(detailsByCollegeCode);
	}

	@GetMapping("/all")
	public List<CollegeVO> getAllCollegeDetails() {
		List<CollegeVO> allCollege = this.collegeService.getAllCollege();

		return allCollege;

	}

	@GetMapping("/response/list")
	public ResponseEntity<?> getCollegeListResponse() {
		List<AllCollegeResponse> collegeResponse = this.collegeService.getCollegeResponse();
		return ResponseEntity.status(HttpStatus.OK).body(collegeResponse);
	}

}
