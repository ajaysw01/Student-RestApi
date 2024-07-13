package com.aj.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

	 @ExceptionHandler(StudentNotFoundException.class)
	    public ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException ex) {
	        Map<String, Object> body = new HashMap<>();
	        body.put("message", "Student not found");
	        body.put("details", ex.getMessage());
	        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", "Internal server error");
        body.put("details", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
