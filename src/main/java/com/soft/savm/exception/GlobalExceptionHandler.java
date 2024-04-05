/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soft.savm.exception;

import com.soft.savm.dao.user.InvalidArguemntsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author PMYLS
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(InvalidArguemntsException.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex){
        ErrorResponse error = new ErrorResponse(ex.getMessage(), true);
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
      @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(Exception ex){
        ErrorResponse error = new ErrorResponse(ex.getMessage(), true);
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    
       @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(Exception ex){
        ErrorResponse error = new ErrorResponse(ex.getMessage(), true);
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
