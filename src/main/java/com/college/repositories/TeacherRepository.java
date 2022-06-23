package com.college.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.entities.Teacher;

@Repository
public interface TeacherRepository  extends JpaRepository<Teacher, Serializable>{

}
