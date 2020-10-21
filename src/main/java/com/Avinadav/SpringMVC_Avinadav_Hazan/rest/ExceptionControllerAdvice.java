package com.Avinadav.SpringMVC_Avinadav_Hazan.rest;

import com.Avinadav.SpringMVC_Avinadav_Hazan.models.ErrorResponse;
import com.Avinadav.SpringMVC_Avinadav_Hazan.rest.ex.FetchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(FetchException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse handleFetchEmployeeEX(FetchException ex) {
        return ErrorResponse.ofNow(ex.getMessage());
    }
}
