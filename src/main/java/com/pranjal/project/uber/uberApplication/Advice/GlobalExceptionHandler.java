package com.pranjal.project.uber.uberApplication.Advice;

import com.pranjal.project.uber.uberApplication.Exceptions.ResourceNotFoundException;
import com.pranjal.project.uber.uberApplication.Exceptions.RuntimeConflictExceptions;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleResourceNotFound(ResourceNotFoundException exception){

        ApiError error =ApiError.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(exception.getMessage())
                .build();
        return buildErrorResponseEntity(error);
    }

    @ExceptionHandler(RuntimeConflictExceptions.class)
    public ResponseEntity<ApiResponse<?>> handleRuntimeConflictExceptions(RuntimeConflictExceptions exception){

        ApiError error =ApiError.builder()
                .status(HttpStatus.CONFLICT)
                .message(exception.getMessage())
                .build();
        return buildErrorResponseEntity(error);
    }



/*    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiResponse<?>> handleBadCredentialException(BadCredentialsException exception){

        ApiError error =ApiError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(new ApiResponse<>(error),HttpStatus.BAD_REQUEST);
    }*/

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>>  handleInternalServerError(Exception exception){

        ApiError error =ApiError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(exception.getMessage())
                .build();
        return buildErrorResponseEntity(error);
        
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleInputValidationsError(MethodArgumentNotValidException methodArgumentNotValidException){

        List<String > errors= methodArgumentNotValidException.getBindingResult().
                getAllErrors().
                stream()
                .map(error->error.getDefaultMessage())
                .toList();

        ApiError error =ApiError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message("Input Validation Failed")
                .subError(errors)
                .build();
        return buildErrorResponseEntity(error);

    }



    private ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(ApiError error) {

        return  new ResponseEntity<>(new ApiResponse<>(error),error.getStatus());

    }
}
