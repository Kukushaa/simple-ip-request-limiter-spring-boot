package com.example.testspringboot.controller;

import com.example.testspringboot.exception.CustomException;
import com.example.testspringboot.http.response.ErrorExceptionResponse;
import com.example.testspringboot.utils.ExceptionsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleOtherExceptions(Exception exception) {
        return getResponseEntity(exception, ExceptionsUtils.DEFAULT_EXCEPTION_MESSAGE);
    }

    @ExceptionHandler({CustomException.class})
    public ResponseEntity<Object> handleCustomException(CustomException exception) {
        return getResponseEntity(exception, exception.getMessage());
    }

    private ResponseEntity<Object> getResponseEntity(Exception exception, String exceptionMessage) {
        LOGGER.error("{} caused: {}", exception.getClass().getSimpleName(), exception.getMessage());
        LOGGER.error(ExceptionsUtils.createStackTraceForException(exception));

        return new ResponseEntity<>(new ErrorExceptionResponse(HttpStatus.FORBIDDEN, exceptionMessage, new Date()), HttpStatus.FORBIDDEN);
    }
}
