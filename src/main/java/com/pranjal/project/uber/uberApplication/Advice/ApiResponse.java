package com.pranjal.project.uber.uberApplication.Advice;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

    private LocalDateTime timeStaamp;
    private T data;
    private ApiError error;

    public ApiResponse(){
        this.timeStaamp=LocalDateTime.now();
    }

    public  ApiResponse(T data){
        this();
        this.data=data;
    }
    public ApiResponse( ApiError error){
        this();
        this.error=error;

    }

}
