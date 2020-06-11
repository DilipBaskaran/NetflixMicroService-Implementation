package com.techmahindra.associatesprojectentry.exceptionhandling;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandler
{   
    @ExceptionHandler(ServletRequestBindingException.class)
    public final ResponseEntity<Object> handleHeaderException(Exception ex, WebRequest request) 
    {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Bad Request", details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(InvalidConfigurationPropertyValueException.class)
    public final ResponseEntity<Object> handleResourceNotFoundException(Exception ex, WebRequest request) 
    {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Not Found", details);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }
     
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) 
    {
    	ex.printStackTrace();
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Server Error", details);
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
