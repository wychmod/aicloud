package com.wychmod.aicloud.util;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(BindException.class)
    public ResponseEntity exceptionHandler(BindException e) {
        return ResponseEntity.fail(e.getBindingResult().getAllErrors().getFirst().getDefaultMessage());
    }
}
