package com.example.oddleweatherapi.exceptions;

import liquibase.pro.packaged.E;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(
            HttpServletRequest req, RuntimeException ex){

        String er = ex.getMessage();
        return buildResponseEntity(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, er));
    }

//    @ExceptionHandler(BadRequestException.class)
//    public ResponseEntity<Object> handleBadRequestException(
//            HttpServletRequest req, BadRequestException ex){
//
//        String er = ex.getMessage();
//        return buildResponseEntity(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, er));
//    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleItemNotFoundException(
            HttpServletRequest req, BadRequestException ex){

        String er = ex.getMessage();
        return buildResponseEntity(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, er));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleSameElementException(HttpServletRequest req, BadRequestException ex){
        String er = ex.getMessage();
        return buildResponseEntity(new ErrorResponse(HttpStatus.SEE_OTHER, er));
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse){
        return new ResponseEntity<Object>(errorResponse, errorResponse.getStatus());
    }
}
