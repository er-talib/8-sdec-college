package com.college.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "college_details")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class College {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short collegeCode ;
	@NotEmpty
	private String collegeName ;
	private String collegeAddress ;
	@NotNull
	private String chairmanName ;
	private String directorName ;
	@Temporal(TemporalType.TIMESTAMP)
	private Date collegeOpenDate ;
	@Temporal(TemporalType.TIMESTAMP)
	private Date collegeDetailsUpdateDates ;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL , mappedBy = "college")
	private FeadBack feadback ;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "college")
	private List<Department> department ;
	

}
