package com.adridev.gymex.controller;

import com.adridev.gymex.models.ValidationError;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationError>> handleValidationException(MethodArgumentNotValidException ex) {
        List<ValidationError> errors = new ArrayList<>();

        ex.getFieldErrors().forEach(error -> {
            ValidationError validationError = new ValidationError();
            validationError.setField(error.getField());
            validationError.setMessage(error.getDefaultMessage());
            errors.add(validationError);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    /*@ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<ValidationError>> handleValidationException(ConstraintViolationException ex) {
        List<ValidationError> errors = new ArrayList<>();

        ex.getConstraintViolations().forEach(error -> {
            ValidationError validationError = new ValidationError();
            validationError.setField(error.getMessageTemplate());
            validationError.setMessage(error.getMessage());
            errors.add(validationError);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }*/

}
