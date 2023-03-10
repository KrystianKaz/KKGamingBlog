package com.site.gamingblog.exception.handlers;

import com.site.gamingblog.exception.RequestNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RequestNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(RequestNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String requestNotFoundHandler(RequestNotFoundException exc) {
        return exc.getMessage();
    }
}
