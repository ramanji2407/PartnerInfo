package com.example.partnerinfo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionalHandler {
	@ExceptionHandler(PartnerDetailsNotFoundException.class)
	public  ResponseEntity<?> projectDetailsException(PartnerDetailsNotFoundException detailsNotFoundException)
	{
		ExceptionResponse response= new ExceptionResponse();
		response.setMessage(detailsNotFoundException.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setTimestamp(new Date());
		
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}

}
