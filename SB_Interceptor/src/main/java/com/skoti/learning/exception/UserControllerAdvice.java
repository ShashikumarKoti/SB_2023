package com.skoti.learning.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(APIException.class)
    public ResponseEntity<Object> handleAPIException(APIException apiException) {
        return new ResponseEntity<>(apiException.getErrors(), apiException.getHttpStatusCode());
    }
}
