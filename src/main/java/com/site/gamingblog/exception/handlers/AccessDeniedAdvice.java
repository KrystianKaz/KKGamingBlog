package com.site.gamingblog.exception.handlers;

import com.site.gamingblog.exception.AccessDeniedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AccessDeniedAdvice {

    @ResponseBody
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String accessDeniedHandler(AccessDeniedException exc) {
        return exc.getMessage();
    }
}
