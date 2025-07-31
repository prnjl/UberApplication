package com.pranjal.project.uber.uberApplication.Exceptions;

import lombok.Data;

public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException() {


    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
