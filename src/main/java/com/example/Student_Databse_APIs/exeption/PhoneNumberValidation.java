package com.example.Student_Databse_APIs.exeption;

public class PhoneNumberValidation extends RuntimeException{
    public PhoneNumberValidation(String message) {
        super(message);
    }
}
