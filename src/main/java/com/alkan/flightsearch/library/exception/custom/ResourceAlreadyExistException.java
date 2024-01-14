package com.alkan.flightsearch.library.exception.custom;

public class ResourceAlreadyExistException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private String fieldValue;

    public ResourceAlreadyExistException(String resourceName , String fieldName , String fieldValue){
        super(String.format("%s already exists with %s : '%s'" , resourceName , fieldName , fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
