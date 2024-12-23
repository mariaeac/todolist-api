package com.meac.todolistapi.services.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleException(MethodArgumentNotValidException e) {
        List<String> errors = e.getBindingResult().getFieldErrors().stream().map(error -> error.getField() + ": "
        + error.getDefaultMessage()).collect(Collectors.toList());

        ApiError apiError = new ApiError(Instant.now(), "Validation Error", errors);
        return ResponseEntity.badRequest().body(apiError);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiError> handleBusinessException(BusinessException e) {
        ApiError apiError = new ApiError(Instant.now() ,e.getMessage(), Collections.singletonList(e.getMessage()));
        return ResponseEntity.badRequest().body(apiError);

    }

}
