package com.site.gamingblog.exception.handlers;

import com.site.gamingblog.exception.PrincipalIsNullException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PrincipalIsNullAdvice {

    @ResponseBody
    @ExceptionHandler(PrincipalIsNullException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String PrincipalIsNullHandler(PrincipalIsNullException exc){
        return exc.getMessage();
    }
}
