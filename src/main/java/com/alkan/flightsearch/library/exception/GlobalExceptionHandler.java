package com.alkan.flightsearch.library.exception;

import com.alkan.flightsearch.library.exception.custom.ResourceAlreadyExistException;
import com.alkan.flightsearch.library.exception.custom.ResourceNotFoundException;
import com.alkan.flightsearch.library.rest.MetaResponse;
import com.alkan.flightsearch.library.rest.Response;
import com.alkan.flightsearch.library.rest.ResponseBuilder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public Response<MetaResponse> resourceNotFound(ResourceNotFoundException e) {
        return ResponseBuilder.build(new MetaResponse("404", e.getMessage()));

    }

    @ExceptionHandler(ResourceAlreadyExistException.class)
    public Response<MetaResponse> resourceAlreadyExists(ResourceAlreadyExistException e) {
        return ResponseBuilder.build(new MetaResponse("409", e.getMessage()));
    }

}
