package com.FXDealer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ExceptionHandler {
    public static ResponseEntity<?> getResponseEntity(ValidationException e){
        //We write this method in one place to make it generalized and for easy reuse and modification.
        ErrorCode errorCode = e.getErrorCode();
        String errorMessage = e.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errorCode.getCode(), errorMessage));
    }
}
