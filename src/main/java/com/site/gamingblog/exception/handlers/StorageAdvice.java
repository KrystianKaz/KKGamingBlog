package com.site.gamingblog.exception.handlers;

import com.site.gamingblog.exception.StorageException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StorageAdvice {

    @ResponseBody
    @ExceptionHandler(StorageException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String storageHandler(StorageException exc) {
        return exc.getMessage();
    }
}
