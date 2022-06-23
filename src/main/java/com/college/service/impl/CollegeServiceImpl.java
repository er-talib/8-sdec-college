package com.college.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.college.co.CollegeCO;
import com.college.co.FeadBackCO;
import com.college.entities.College;
import com.college.entities.Department;
import com.college.entities.FeadBack;
import com.college.entities.Teacher;
import com.college.repositories.CollegeRepository;
import com.college.response.AllCollegeResponse;
import com.college.response.CollegeDetailsUpdateResponse;
import com.college.response.CollegeResponse;
import com.college.response.DepartmentResponse;
import com.college.response.TeacherResponse;
import com.college.service.CollegeService;
import com.college.vo.CollegeVO;
import com.college.vo.DepartmentVO;
import com.college.vo.FeadbackVO;
import com.college.vo.TeacherVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CollegeServiceImpl implements CollegeService {

	private final CollegeRepository collegeRepository;

	@Override
	public CollegeResponse addCollegeDetails(CollegeCO collegeCO) {

		College college = new College();
		college.setChairmanName(collegeCO.getChairmanName());
		college.setCollegeAddress(collegeCO.getCollegeAddress());
		college.setCollegeName(collegeCO.getCollegeName());
		college.setCollegeOpenDate(new Date());
		college.setDirectorName(collegeCO.getDirectorName());

		FeadBack fb = new FeadBack();
		fb.setCollegeName(collegeCO.getFeadback().getCollegeName());
		fb.setFeadback(collegeCO.getFeadback().getFeadBack());
		fb.setFeadbackDate(new Date());
		fb.setCollege(college);
		college.setFeadback(fb);

		List<Department> department = collegeCO.getDepartment().stream().map(depp -> {
			Department dep = new Department();
			dep.setDepName(depp.getDepName());
			dep.setDepHeadName(depp.getDepHeadName());
			dep.setDepStatus(depp.getDepStatus());
			dep.setTotalStaff(depp.getTotalStaff());
			dep.setDepartmentOpenDate(new Date());
			dep.setCollege(college);

			List<Teacher> teacher = depp.getTeacher().stream().map(te -> {
				Teacher t = new Teacher();
				t.setHiredBy(te.getHiredBy());
				t.setTeacherAddress(te.getTeacherAddress());
				t.setTeacherJoiningDate(new Date());
				t.setTeacherName(te.getTeacherName());
				t.setTeacherQuitDate(new Date());
				t.setDepartment(dep);
				return t;
			}).collect(Collectors.toList());

			dep.setTeacher(teacher);
			return dep;

		}).collect(Collectors.toList());

		college.setDepartment(department);

		this.collegeRepository.save(college);

		Optional<College> collegeDetails = this.collegeRepository.findById(college.getCollegeCode());
		College college2 = collegeDetails.get();
		CollegeResponse cr = new CollegeResponse();
		cr.setMessage("Your Details add successfully");
		cr.setStatus("Done");
		cr.setCollegeName(college2.getCollegeName());

		return cr;
	}

	@Override
	public CollegeVO getDetailsByCollegeCode(short collegeCode) {

		Optional<College> collegeDetails = this.collegeRepository.findById(collegeCode);
		College college = collegeDetails.get();

		CollegeVO cvo = new CollegeVO();
		cvo.setChairmanName(college.getChairmanName());
		cvo.setCollegeAddress(college.getCollegeAddress());
		cvo.setCollegeName(college.getCollegeName());
		cvo.setCollegeOpenDate(college.getCollegeOpenDate());
		cvo.setDirectorName(college.getDirectorName());
		FeadbackVO fc = new FeadbackVO();
		fc.setCollegeName(college.getFeadback().getCollegeName());
		fc.setFeadBack(college.getFeadback().getFeadback());
		fc.setFeadBackDate(college.getFeadback().getFeadbackDate());

		cvo.setFeadback(fc);

		List<DepartmentVO> departmentVo = college.getDepartment().stream().map(dep -> {
			DepartmentVO dv = new DepartmentVO();
			dv.setDepartmentOpenDate(dep.getDepartmentOpenDate());
			dv.setDepHeadName(dep.getDepHeadName());
			dv.setDepName(dep.getDepName());
			dv.setDepStatus(dep.getDepStatus());
			dv.setTotalStaff(dep.getTotalStaff());
//			dv.setCollege(cvo);

			List<TeacherVO> teacherVo = dep.getTeacher().stream().map(te -> {
				TeacherVO to = new TeacherVO();
				to.setHiredBy(te.getHiredBy());
				to.setTeacherAddress(te.getTeacherAddress());
				to.setTeacherJoiningDate(te.getTeacherJoiningDate());
				to.setTeacherName(te.getTeacherName());
				to.setTeacherQuitDate(te.getTeacherQuitDate());
//				to.setDepartment(dv);

				return to;
			}).collect(Collectors.toList());

			dv.setTeacher(teacherVo);
			return dv;
		}).collect(Collectors.toList());
		cvo.setDepartment(departmentVo);
		return cvo;
	}

	@Override
	public CollegeDetailsUpdateResponse updateCollegeDetails(CollegeCO collegeCO, short collegeCode) {

		College college = new College();
		college.setCollegeCode(collegeCode);
		college.setChairmanName(collegeCO.getChairmanName());
		college.setCollegeAddress(collegeCO.getCollegeAddress());
		college.setCollegeName(collegeCO.getCollegeName());
		college.setCollegeOpenDate(new Date());
		college.setCollegeDetailsUpdateDates(new Date());
		college.setDirectorName(collegeCO.getDirectorName());

		FeadBack fb = new FeadBack();
		fb.setCollegeCode(collegeCO.getFeadback().getFeadbackId());
		;
		fb.setCollegeName(collegeCO.getFeadback().getCollegeName());
		fb.setFeadbackDate(new Date());
		fb.setFeadback(collegeCO.getFeadback().getFeadBack());
		fb.setCollege(college);

		college.setFeadback(fb);

		List<Department> department = collegeCO.getDepartment().stream().map(dp -> {
			Department dep = new Department();
			dep.setDepCode(dp.getDepCode());
			dep.setCollege(college);
			dep.setDepartmentOpenDate(new Date());
			dep.setDepHeadName(dp.getDepHeadName());
			dep.setDepName(dp.getDepName());
			dep.setDepStatus(dp.getDepStatus());
			dep.setTotalStaff(dp.getTotalStaff());

			List<Teacher> teacher = dp.getTeacher().stream().map(t -> {
				Teacher te = new Teacher();
				te.setTeacherId(t.getTeacherId());
				te.setDepartment(dep);
				te.setHiredBy(t.getHiredBy());
				te.setTeacherAddress(t.getTeacherAddress());
				te.setTeacherJoiningDate(new Date());
				te.setTeacherName(t.getTeacherName());
				te.setTeacherQuitDate(new Date());
				return te;
			}).collect(Collectors.toList());

			dep.setTeacher(teacher);
			return dep;

		}).collect(Collectors.toList());

		college.setDepartment(department);
		this.collegeRepository.save(college);

		Optional<College> collegeDetails = this.collegeRepository.findById(college.getCollegeCode());
		College coll = collegeDetails.get();
		CollegeDetailsUpdateResponse response = new CollegeDetailsUpdateResponse();
		response.setCollegeDetailsUpdateId(coll.getCollegeCode());
		response.setCollegeName(coll.getCollegeName());
		response.setStatus("Active");
		response.setMessage("Your college details updated successfully..!!");

		return response;
	}

	@Override
	public String deleteCollegeDetailsByCollegeCode(short collegeCode) {
		this.collegeRepository.deleteById(collegeCode);
		return "Deleted college details successfully..!!";
	}

	@Override
	public List<CollegeVO> getAllCollege() {

		List<College> findAll = this.collegeRepository.findAll();
		List<CollegeVO> collect = findAll.stream().map(college -> {

//				College college = collegeDetails.get();

			CollegeVO cvo = new CollegeVO();
			cvo.setChairmanName(college.getChairmanName());
			cvo.setCollegeAddress(college.getCollegeAddress());
			cvo.setCollegeName(college.getCollegeName());
			cvo.setCollegeOpenDate(college.getCollegeOpenDate());
			cvo.setDirectorName(college.getDirectorName());
			FeadbackVO fc = new FeadbackVO();
			fc.setCollegeName(college.getFeadback().getCollegeName());
			fc.setFeadBack(college.getFeadback().getFeadback());
			fc.setFeadBackDate(college.getFeadback().getFeadbackDate());

			cvo.setFeadback(fc);

			List<DepartmentVO> departmentVo = college.getDepartment().stream().map(dep -> {
				DepartmentVO dv = new DepartmentVO();
				dv.setDepartmentOpenDate(dep.getDepartmentOpenDate());
				dv.setDepHeadName(dep.getDepHeadName());
				dv.setDepName(dep.getDepName());
				dv.setDepStatus(dep.getDepStatus());
				dv.setTotalStaff(dep.getTotalStaff());
//					dv.setCollege(cvo);

				List<TeacherVO> teacherVo = dep.getTeacher().stream().map(te -> {
					TeacherVO to = new TeacherVO();
					to.setHiredBy(te.getHiredBy());
					to.setTeacherAddress(te.getTeacherAddress());
					to.setTeacherJoiningDate(te.getTeacherJoiningDate());
					to.setTeacherName(te.getTeacherName());
					to.setTeacherQuitDate(te.getTeacherQuitDate());
//						to.setDepartment(dv);

					return to;
				}).collect(Collectors.toList());

				dv.setTeacher(teacherVo);
				return dv;
			}).collect(Collectors.toList());
			cvo.setDepartment(departmentVo);

			return cvo;
		}).collect(Collectors.toList());

		return collect;
	}

	@Override
	public List<AllCollegeResponse> getCollegeResponse() {

		List<College> allCollegeDetails = this.collegeRepository.findAll();

		List<AllCollegeResponse> allClgResponse = allCollegeDetails.stream().map(clg -> {
			AllCollegeResponse allClgRes = new AllCollegeResponse();
			allClgRes.setCollegeCode(clg.getCollegeCode());
			allClgRes.setCollegeName(clg.getCollegeName());
			allClgRes.setDirector(clg.getDirectorName());

			List<DepartmentResponse> depRes = clg.getDepartment().stream().map(dep -> {
				DepartmentResponse dp = new DepartmentResponse();
				dp.setDepCode(dep.getDepCode());
				dp.setDepartmetName(dep.getDepName());
				dp.setStatus(dep.getDepStatus());

				List<TeacherResponse> teaRes = dep.getTeacher().stream().map(tea -> {
					TeacherResponse tr = new TeacherResponse();
					tr.setTeacherId(tea.getTeacherId());
					tr.setTeacherName(tea.getTeacherName());

					return tr;
				}).collect(Collectors.toList());
				
				dp.setTeacherResponse(teaRes);
				return dp;

			}).collect(Collectors.toList());

			allClgRes.setDepartmentResponse(depRes);
			return allClgRes;

		}).collect(Collectors.toList());

		return allClgResponse;
	}

}
