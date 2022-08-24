package com.example.demo.controller.advice;

import java.sql.SQLException;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.BoardNotFoundException;
import com.example.demo.exception.JobFailException;

@RestControllerAdvice
public class BoardControllerAdvice {
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<String> sQLException(SQLException e) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	}
	
	@ExceptionHandler(BoardNotFoundException.class)
	public ResponseEntity<String> BNFExption() {
		return ResponseEntity.status(HttpStatus.CONFLICT).body("게시물을 찾을 수 없습니다.");
	}
	
	@ExceptionHandler(JobFailException.class)
	public ResponseEntity<String> JFExption(JobFailException e) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> constraintViolationException() {
		return ResponseEntity.status(HttpStatus.CONFLICT).body("데이터가 누락되었습니다");
	}
}
