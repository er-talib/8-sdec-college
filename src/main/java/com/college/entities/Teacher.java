package com.college.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "teacher_details")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short teacherId;
	private String teacherName;
	@Temporal(TemporalType.TIMESTAMP)
	private Date teacherJoiningDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date teacherQuitDate;
	private String hiredBy;
	private String teacherAddress ;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_dep_code")
	private Department department;

}
