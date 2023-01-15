package com.site.gamingblog.exception.handlers;

import com.site.gamingblog.exception.CreatedUserExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CreatedUserExistAdvice {

    @ResponseBody
    @ExceptionHandler(CreatedUserExistException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String registerException(CreatedUserExistException exc) {
        return exc.getMessage();
    }
}