package com.college.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.entities.FeadBack;

@Repository
public interface FeadbackRepository extends JpaRepository<FeadBack, Serializable>{

}
