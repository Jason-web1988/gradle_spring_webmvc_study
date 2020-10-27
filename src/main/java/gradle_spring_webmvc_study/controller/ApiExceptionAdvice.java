package gradle_spring_webmvc_study.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import gradle_spring_webmvc_study.dto.ErrorResponse;
import gradle_spring_webmvc_study.exception.MemberNotFoundException;

@RestControllerAdvice("gradle_spring_webmvc_study.controller")
public class ApiExceptionAdvice {

	@ExceptionHandler(MemberNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNoData(){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("no member"));
	}
}
