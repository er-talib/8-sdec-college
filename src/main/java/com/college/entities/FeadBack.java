package com.college.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "college_feadback")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class FeadBack {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short collegeCode ;
	@NotBlank
	private String collegeName ;
	@Length(min = 10 , max = 500)
	private String feadback ;
	@Temporal(TemporalType.TIMESTAMP)
	private Date feadbackDate ;
	@OneToOne
	private College college ;

}
