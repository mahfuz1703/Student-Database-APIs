package com.example.Student_Databse_APIs.exeption;

import com.example.Student_Databse_APIs.response.ApiResponse;
import com.example.Student_Databse_APIs.response.ExceptionResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Slf4j
@RestControllerAdvice
public class GlobalExeptionHandler {

//    @ExceptionHandler(value = {EntityNotFoundException.class})
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ProblemDetail handleEntityNotFoundException(EntityNotFoundException ex) {
//        log.error("EntityNotFoundException: {}", ex.getMessage());
//        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
//    }

//    @ExceptionHandler(value = PhoneNumberValidation.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ProblemDetail phoneNumberValidationHandler(PhoneNumberValidation ex){
//        log.error("PhoneNumberValidation Exception: {}", ex.getMessage());
//        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
//    }

//    @ExceptionHandler(value = {RuntimeException.class})
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ProblemDetail handleRuntimeException(RuntimeException ex) {
//        log.error("RuntimeException: {}", ex.getMessage());
//        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
//    }


    // with custom response entity-------------------
//    @ExceptionHandler(value = PhoneNumberValidation.class)
//    public  ResponseEntity<ExceptionResponse> phoneNumberValidationHandler(PhoneNumberValidation ex){
//        log.error("PhoneNumberValidation Exception: {}", ex.getMessage());
//
//        ExceptionResponse response = new ExceptionResponse();
//        response.setStatus("BAD REQUEST");
//        response.setStatusCode(HttpStatus.BAD_REQUEST.value());
//        response.setMessage(ex.getMessage());
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }

//    @ExceptionHandler(value = RuntimeException.class)
//    public ResponseEntity<ExceptionResponse> handleRuntimeException(RuntimeException ex){
//        log.error("RuntimeException: {}", ex.getMessage());
//
//        ExceptionResponse response = new ExceptionResponse();
//        response.setStatus("BAD REQUEST");
//        response.setStatusCode(HttpStatus.BAD_REQUEST.value());
//        response.setMessage(ex.getMessage());
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }


    // with more customized response entity-------------------
    @ExceptionHandler(value = PhoneNumberValidation.class)
    public ResponseEntity<ApiResponse<?>> phoneNumberValidationHandler(PhoneNumberValidation ex){
        log.error("PhoneNumberValidation Exception: {}", ex.getMessage());

        ApiResponse<?> response = new ApiResponse<>(
                HttpStatus.BAD_REQUEST.toString(),
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                true,
                null
        );
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ApiResponse<?>> handleRuntimeException(RuntimeException ex) {
        log.error("RuntimeException: {}", ex.getMessage());
        ApiResponse<?> response = new ApiResponse<>(
                HttpStatus.BAD_REQUEST.toString(),
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                true,
                null
        );
        return ResponseEntity.badRequest().body(response);
    }
}
