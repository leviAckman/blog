package com.levi.log.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BlogNotFoundException extends RuntimeException{
    public BlogNotFoundException(){

    }

    public BlogNotFoundException(String message){
        super(message);
    }
}
