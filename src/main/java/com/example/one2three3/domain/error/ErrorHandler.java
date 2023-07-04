package com.example.one2three3.domain.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.net.BindException;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ErrorResponse> masterExceptions(DomainException e) {
        ErrorResponse errorResponse = ErrorResponse.of(e.errorCode);
        return of(errorResponse);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(BindException e){
        ErrorResponse errorResponse = new ErrorResponse("", "", HttpStatus.BAD_REQUEST.value());
        return of(errorResponse);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> handleParameterExceptions(){
        ErrorResponse errorResponse = new ErrorResponse("", "", HttpStatus.BAD_REQUEST.value());
        return of(errorResponse);
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<ErrorResponse> handleHeaderExceptions() {
        ErrorResponse errorResponse = new ErrorResponse("", "", HttpStatus.BAD_REQUEST.value());
        return of(errorResponse);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleMethodExceptions() {
        ErrorResponse errorResponse = new ErrorResponse("", "", HttpStatus.BAD_REQUEST.value());
        return of(errorResponse);
    }

    private ResponseEntity<ErrorResponse> of(ErrorResponse errorResponse) {
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorResponse.status()));
    }
}