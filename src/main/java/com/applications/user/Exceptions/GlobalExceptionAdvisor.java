package com.applications.user.Exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionAdvisor {
    @ExceptionHandler
    public void handle(HttpRequestMethodNotSupportedException e){
        throw new BadRequestException("HTTP Request type not supported");
    }
}
