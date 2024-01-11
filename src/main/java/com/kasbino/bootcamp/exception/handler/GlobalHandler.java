package com.kasbino.bootcamp.exception.handler;

import com.kasbino.bootcamp.exception.custom.DuplicateAdminException;
import com.kasbino.bootcamp.exception.custom.DuplicateUserException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(value = DuplicateUserException.class)
    public ResponseEntity<String> duplicateUserExceptionHandler(DuplicateUserException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = DuplicateAdminException.class)
    public ResponseEntity<String> duplicateAdminExceptionHandler(DuplicateAdminException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<String> entityNotFoundExceptionHandler(EntityNotFoundException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
