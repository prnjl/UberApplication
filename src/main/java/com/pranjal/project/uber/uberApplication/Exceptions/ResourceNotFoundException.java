package com.pranjal.project.uber.uberApplication.Exceptions;

public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException() {


    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
