package com.example.Student_Databse_APIs.response;

import lombok.Data;

@Data
public class ExceptionResponse {
    private String status;
    private int statusCode;
    private String message;
}
