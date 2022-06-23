package com.college.controller.advice;

import java.util.Date;
import java.util.logging.ErrorManager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.college.exception.CollegeDetailsNotFound;
import com.college.vo.ErrorMessage;

@RestControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CollegeDetailsNotFound.class)
	public ResponseEntity<ErrorMessage> collegeDetailsNotFound(CollegeDetailsNotFound collegeDetailsNotFound) {
		ErrorMessage er = new ErrorMessage();
		er.setStatus(HttpStatus.NO_CONTENT);
		er.setTimestamp(new Date());
		er.setMessage(collegeDetailsNotFound.getMessage());

		return new ResponseEntity<ErrorMessage>((er) , er.getStatus());
	}

}
