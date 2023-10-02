package com.arquisoft2023II.clinic_history_ms.exceptions;

public class ValidationErrorException extends RuntimeException{

    public ValidationErrorException(String message){
        super(message);
    }
}
