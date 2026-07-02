package com.example.companyms.exceptions;

import com.example.companyms.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CompanyNotFoundExceptions.class)
    public ResponseEntity<?> handleCompanyNotFoundException(CompanyNotFoundExceptions companyNotFoundExceptions)
    {
        ErrorResponse errorResponse=new ErrorResponse();

        errorResponse.setTime(LocalDateTime.now());
        errorResponse.setMessage("Company with this id not found in database");
        errorResponse.setDetails(companyNotFoundExceptions.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(CompanyNotFoundExceptions.class)
//    @ResponseBody
//    public String handleCompanyNotFoundException(CompanyNotFoundExceptions companyNotFoundExceptions)
//    {
//        ErrorResponse errorResponse=new ErrorResponse();
//
//        errorResponse.setTime(LocalDateTime.now());
//        errorResponse.setMessage("Company with this id not found in database");
//        errorResponse.setDetails(companyNotFoundExceptions.getMessage());
//
//        return "No company found with this id";
//    }
}
